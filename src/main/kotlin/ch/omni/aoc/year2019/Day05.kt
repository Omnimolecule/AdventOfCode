package ch.omni.aoc.year2019

import readFile

object Day05 {

    fun start() {
        val input = readFile(2019, 5).split(",").map { it.toInt() }
        part1(input)
    }

    fun part1(inputList: List<Int>) {
        calculate(inputList)
    }

    fun part2() {

    }

    fun calculate(input: List<Int>): List<Int> {
        return calculate(input, null, null)
    }

    fun calculate(input: List<Int>, verb: Int?, noun: Int?): List<Int> {
        val newList = input.map { it }.toMutableList()
        if (verb != null) {
            newList[1] = verb
        }
        if (noun != null) {
            newList[2] = noun
        }
        var i = 0
        while (i < newList.size) {
            val instruction = newList[i]
            val opcode = instruction % 100
            val modeParam1 = (instruction / 100) % 10
            val modeParam2 = (instruction / 1000) % 10
            val modeParam3 = (instruction / 10000) % 10
            if (opcode == 99) return newList

            when (opcode) {
                99 -> {
                    println("Done 99")
                    return newList
                }
                1 -> {
                    val val1 = newList[i + 1]
                    val val2 = newList[i + 2]
                    val res = newList[i + 3]
                    val firstParam = getParameter(modeParam1, newList, val1)
                    val secondParam = getParameter(modeParam2, newList, val2)
                    if (modeParam3 == 1) {
                        error("write instructions can never be in immediate mode")
                    }
                    newList[res] = firstParam + secondParam
                    i += 4
                }
                2 -> {
                    val val1 = newList[i + 1]
                    val val2 = newList[i + 2]
                    val res = newList[i + 3]
                    val firstParam = getParameter(modeParam1, newList, val1)
                    val secondParam = getParameter(modeParam2, newList, val2)
                    if (modeParam3 == 1) {
                        error("write instructions can never be in immediate mode")
                    }
                    newList[res] = firstParam * secondParam
                    i += 4
                }
                3 -> {
                    val val1 = newList[i + 1]
                    println("Input please:")
                    newList[val1] = readLine()!!.toInt()
                    i += 2
                }
                4 -> {
                    val val1 = newList[i + 1]
                    val firstParam = getParameter(modeParam1, newList, val1)
                    println("Output: ${firstParam}")
                    i += 2
                }
                else -> {
                    println("Done $opcode")
                    return newList
                }
            }
        }
        println("Done End")
        return listOf()
    }

    fun getParameter(mode: Int, inputList: List<Int>, value: Int): Int {
        return when (mode) {
            0 -> inputList[value]
            1 -> value
            else -> error("wrong parameter")
        }
    }

    fun test1() {
        calculate(listOf(3, 0, 4, 0, 99))
        calculate(listOf(1002, 4, 3, 4, 33))
        calculate(listOf(1101, 100, -1, 4, 0))
    }

    fun test2() {

    }
}

fun main(args: Array<String>) {
    Day05.start()
}