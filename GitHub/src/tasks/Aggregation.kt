package tasks

import contributors.User

/*
TODO: Write aggregation code.

 In the initial list each user is present several times, once for each
 repository he or she contributed to.
 Merge duplications: each user should be present only once in the resulting list
 with the total value of contributions for all the repositories.
 Users should be sorted in a descending order by their contributions.

 The corresponding test can be found in test/tasks/AggregationKtTest.kt.
 You can use 'Navigate | Test' menu action (note the shortcut) to navigate to the test.
*/

/**
 * Hint: Use either `groupBy()` or `groupingBy()` and `sortedByDescending()` functions.
 */
// [User("john", 2), User("john", 3), User("Peter", 2) ]
// -> [
//      ("john", [User("john", 3), User("john", 2)]),
//      ("Peter", [User("Peter", 2)])
//    ]
// -> [User("john", 5), User("Peter", 2)]
fun List<User>.aggregate(): List<User> = TODO()