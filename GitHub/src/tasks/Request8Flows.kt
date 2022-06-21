package tasks

import contributors.GitHubService
import contributors.RequestData
import contributors.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope

@ExperimentalCoroutinesApi
suspend fun loadContributorsFlows(service: GitHubService,
                                  req: RequestData,
                                  updateResults: suspend (List<User>, completed: Boolean) -> Unit
) = coroutineScope {

    TODO() as Unit // temporary
}