package tasks

import contributors.*
import kotlinx.coroutines.*

/*
 * Copy the content from `loadContributorsSuspend` to the `coroutineScope` call,
 * so that we can call `async` functions there:
 */
suspend fun loadContributorsConcurrent(
    service: GitHubService, req: RequestData
): List<User> = coroutineScope {
    // Base the solution on the following scheme:

    /*
    val deferreds: List<Deferred<List<User>>> = repos.map { repo ->
        async {
            // load contributors for each repo
        }
    }
    deferreds.awaitAll() // List<List<User>>
    */
    emptyList() // temporary
}