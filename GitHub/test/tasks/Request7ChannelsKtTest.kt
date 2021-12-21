package tasks

import contributors.MockGithubService
import contributors.concurrentProgressResults
import contributors.testRequestData
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class Request7ChannelsKtTest {
    @Test
    fun testChannels() = runBlocking {
        val startTime = System.currentTimeMillis()
        var index = 0
        loadContributorsChannels(MockGithubService, testRequestData) {
                users, _ ->
            val expected = concurrentProgressResults[index++]
            val time = System.currentTimeMillis() - startTime

            Assert.assertEquals("Wrong intermediate result after $time:", expected.users, users)
        }
    }
}
