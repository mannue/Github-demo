package collections

fun main() {
    groupByDemo()

    println("-".repeat(50))

    groupingByDemo()
}

val numbers = listOf("one", "two", "three", "four", "five")

fun groupByDemo() {
    val result1: Map<Char, List<String>> = numbers.groupBy { it.first() }
    println(result1)

    println(numbers.groupBy { it.first().uppercase() })

    val result2: Map<Char, List<String>> = numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.uppercase() })
    println(result2)
}

fun groupingByDemo() {
    val result1: Map<Char, Int> = numbers.groupingBy { it.first() }.eachCount()
    println(result1)

    val result2: Map<Char, String> = numbers.groupingBy { it.first() }.reduce { _, acc, elem -> acc + elem }
    println(result2)

    val result3: Map<Char, List<String>> =
        numbers.groupingBy { it.first() }.fold(emptyList()) { acc, elem -> acc + elem }
    println(result3)

    println(
        numbers.groupingBy { it.first() }.aggregate { _, acc: StringBuilder?, elem, first ->
            if (first) StringBuilder().append(elem.uppercase()) else acc?.append(elem)
        }
    )
}

