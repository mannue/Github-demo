package tasks

import contributors.*
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
suspend fun loadContributorsFlows(
    service: GitHubService,
    req: RequestData,
    updateResults: suspend (List<User>, completed: Boolean) -> Unit
) = coroutineScope {

    TODO() as Unit // temporary
}
