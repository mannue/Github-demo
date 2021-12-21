package tasks

import contributors.*

/**
 * Implement the function `loadContributorsProgress` that shows the intermediate progress
 * (in the Request6Progress.kt file). Base it on the `loadContributorsSuspend` function
 * (from Request4Suspend.kt). We'll use a simple version without concurrency.
 * Note that the intermediate list of contributors should be shown in an "aggregated" state,
 * not just the list of users loaded for each repository. The total numbers of contributions
 * for each user should be increased when the data for each new repository is loaded.
 */
suspend fun loadContributorsProgress(
    service: GitHubService,
    req: RequestData,
    updateResults: suspend (List<User>, completed: Boolean) -> Unit
) {
    // loading the data
    // calling `updateResults` on intermediate states
}
