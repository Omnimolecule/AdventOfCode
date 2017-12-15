package ch.omni.aoc.year2017

import java.math.BigDecimal

object Day15 {

    fun start(){
        var inputA = BigDecimal(116)
        var inputB = BigDecimal(299)
        var count = 0

        for (i in 0..39999999) {
            inputA = inputA.multiply(BigDecimal(16807)).rem(BigDecimal(2147483647))
            inputB = inputB.multiply(BigDecimal(48271)).rem(BigDecimal(2147483647))

            val aString = "0000000000000000" + inputA.toInt().toString(2)
            val bString = "0000000000000000" + inputB.toInt().toString(2)

            if (aString.substring(aString.length-16).equals(bString.substring(bString.length-16))) {
                count++
            }
        }
        println(count)
    }
}

fun main(args: Array<String>) {
    Day15.start()
}