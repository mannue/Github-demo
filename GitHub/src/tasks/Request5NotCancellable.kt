package tasks

import contributors.*
import kotlinx.coroutines.*

/**
 * Copy the implementation of `loadContributorsConcurrent` to `loadContributorsNotCancellable`
 * (in Request5NotCancellable.kt) and remove the creation of a new `coroutineScope`.
 * Our `async` calls now fail to resolve, so we need to start them via `GlobalScope.async`:
 */
@DelicateCoroutinesApi
suspend fun loadContributorsNotCancellable(service: GitHubService, req: RequestData): List<User> {

    /*
    // ...
    GlobalScope.async {
        log("starting loading for ${repo.name}")
        delay(3000) // We can add a 3-second delay to all the coroutines sending requests,
        // so that we have enough time to cancel the loading after the
        // coroutines are started, but before the requests are sent.
        // load repo contributors
        // ...
    }

    // ...
    return result
     */
    return emptyList() // temporary
}