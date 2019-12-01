package ch.omni.aoc.year2019

import readFile

object Day01 {

    fun start() {
        val input = readFile(2019, 1)
        part1(input.split("\n"))
    }

    fun part1(input:List<String>) {
        println(input.map{ it.toInt()/3-2 }.sum())
    }

    fun test() {
        part1(listOf("12"))
        part1(listOf("14"))
        part1(listOf("1969"))
        part1(listOf("100756"))
    }


}

fun main(args: Array<String>) {
    Day01.test()
    Day01.start()
}