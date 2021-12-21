package collections

fun main() {
    groupByDemo()
    groupingByDemo()
}

fun groupByDemo() {
    val numbers = listOf("one", "two", "three", "four", "five")

    println(numbers.groupBy { it.first() })
    println(numbers.groupBy { it.first().uppercase() })
    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.uppercase() }))
}

fun groupingByDemo() {
    val numbers = listOf("one", "two", "three", "four", "five")

    println(numbers.groupingBy { it.first() }.eachCount())
    println(numbers.groupingBy { it.first() }.reduce { key, acc, elem -> acc + elem })
    println(numbers.groupingBy { it.first() }.fold(emptyList<String>()) { acc, elem -> acc + elem })
    println(
        numbers.groupingBy { it.first() }.aggregate { key, acc: StringBuilder?, elem, first ->
            if (first) StringBuilder().append(elem.uppercase()) else acc?.append(elem)
        }
    )
}

