import java.io.File

fun day3_1() {
    val lines = File("puzzle-input/input-day-3.txt").readLines()

    val maximums = lines.map { line ->
        val digits: List<Int> = line.map { x -> x.digitToInt() }
        val a = digits.dropLast(1)
        val x = a.indices.maxByOrNull { a[it] }
        val b = digits.drop(x!! + 1)
        val y = b.indices.maxByOrNull { b[it] }
        val max = "${a[x]}${b[y!!]}".toInt()
        max
    }

    println(maximums.sum())
}

fun day3_2() {
    val lines = File("puzzle-input/input-day-3.txt").readLines()

    val maximums = lines.map { line ->
        val digits: List<Int> = line.map { x -> x.digitToInt() }
        // the numbers found for the largest joltage
        val j = mutableListOf<Int>()
        // x is an index to the complete line
        var x = -1
        while (j.size < 12) {
            // narrow down the numbers to consider
            val k = digits.drop(x + 1).dropLast(11 - j.size)
            val h = k.indices.maxByOrNull { k[it] }
            x = x + 1 + h!!
            j.add(digits[x])
        }
        val max = j.joinToString(separator = "")
        max.toBigInteger()
    }

    val sum = maximums.fold(0.toBigInteger()) { acc, integer -> acc.add(integer) }

    println(sum)
}