package tasks

import contributors.GitHubService
import contributors.RequestData
import contributors.User
import kotlinx.coroutines.coroutineScope

/**
 * Implement the function `loadContributorsChannels` that requests all the GitHub contributors
 * concurrently, but shows intermediate progress at the same time. Use these two previous
 * functions: `loadContributorsConcurrent` from Request5Concurrent.kt and `loadContributorsProgress`
 * from Request6Progress.kt.
 */
suspend fun loadContributorsChannels(service: GitHubService,
                                     req: RequestData,
                                     updateResults: suspend (List<User>, completed: Boolean) -> Unit
) = coroutineScope {

    TODO() as Unit // temporary
}