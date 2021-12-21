package contributors

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.Base64

interface GitHubService {
    @GET("orgs/{org}/repos?per_page=100")
    fun getOrgReposCall(
        @Path("org") org: String
    ): Call<List<Repo>>

    @GET("repos/{owner}/{repo}/contributors?per_page=100")
    fun getRepoContributorsCall(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Call<List<User>>

    /**/

    @GET("orgs/{org}/repos?per_page=100")
    suspend fun getOrgRepos(
        @Path("org") org: String
    ): Response<List<Repo>>

    @GET("repos/{owner}/{repo}/contributors?per_page=100")
    suspend fun getRepoContributors(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<List<User>>
}

data class Repo(
    val id: Long,
    val name: String
)

data class User(
    val login: String,
    val contributions: Int
)

data class RequestData(
    val username: String,
    val password: String,
    val org: String
)

fun createGitHubService(username: String, password: String): GitHubService {
    val authToken = "Basic " + Base64.getEncoder().encode("$username:$password".toByteArray())
        .toString(Charsets.UTF_8)
    val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val builder = original.newBuilder()
                .header("Accept", "application/vnd.github.v3+json")
                .header("Authorization", authToken)
            val request = builder.build()
            chain.proceed(request)
        }
        .build()

    val contentType = "application/json".toMediaType()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create()
            )
        )
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(httpClient)
        .build()
    return retrofit.create(GitHubService::class.java)
}
