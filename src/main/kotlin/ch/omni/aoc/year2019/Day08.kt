package ch.omni.aoc.year2019

import readFile

object Day08 {

    fun start() {
        val input = readFile(2019, 8)
        part1(input, 25, 6)
    }

    fun part1(input: String, width: Int, height: Int) {
        //val groups = mutableListOf<List<String>>()
        var idx = 0
        var minZero = width * height
        var result = 0
        while (idx < input.length) {
            val substring = input.substring(idx, idx + (width * height))
            val zeroCount = substring.split("0").size - 1
            if (zeroCount < minZero) {
                minZero = zeroCount
                val oneCount = substring.split("1").size - 1
                val twoCount = substring.split("2").size - 1
                result = oneCount * twoCount
            }
            //groups.add(substring)
            idx += width * height
        }
        println(result)
    }

    fun test1() {
        val input = "123456789012"
        part1(input, 3, 2)
    }
}

fun main(args: Array<String>) {
    Day08.start()
}