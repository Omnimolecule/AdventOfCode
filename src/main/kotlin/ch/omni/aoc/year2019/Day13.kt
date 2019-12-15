package ch.omni.aoc.year2019

import readFile

object Day13 {

    fun start() {
        val input = readFile(2019, 13).split(",").map { it.toLong() }
        part1(input)
    }


    fun part1(input: List<Long>) {
        val pc = IntcodeComputerV4(input, returnOnOutput = true)
        val game: MutableMap<Pair<Long, Long>, Long> = mutableMapOf()

        while (!pc.isDone) {
            val x = pc.calculate().second.last()
            if (pc.isDone) break
            val y = pc.calculate().second.last()
            val tile = pc.calculate().second.last()

            game[Pair(x, y)] = tile
        }

        println(game.toList().filter { it.second == 2L }.size)
    }
}

fun main(args: Array<String>) {
    Day13.start()
}