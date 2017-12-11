package ch.omni.aoc.year2017

fun main(args: Array<String>) {
    val input = INPUT
    var sum = 0;
    val length = (input.length) / 2
    for (idx in input.indices) {
        val value = input[idx]
        val nextIdx = (idx + length) % input.length
        val other = input[nextIdx]
        if (other.equals(value)) {
            sum += value.toString().toInt()
        }
    }
    println(sum)

}