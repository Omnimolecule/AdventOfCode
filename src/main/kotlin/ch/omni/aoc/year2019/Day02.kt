package `2019`

import ch.omni.aoc.year2019.Day01
import readFile

object Day02 {
    fun start() {
        val input = readFile(2019, 2)
        println(part1(input))
    }

    fun part1(input: String): Int {
        val inputSeq = input.split(",").map{it.toInt()}.toMutableList()
        inputSeq[1] = 12
        inputSeq[2] = 2
        for (i in 0 until inputSeq.size step 4) {
            val opcode = inputSeq[i]
            if (opcode == 99) return inputSeq[0]
            val val1 = inputSeq[i+1]
            val val2 = inputSeq[i+2]
            val res = inputSeq[i+3]
            inputSeq[res] = when (opcode) {
                1 -> inputSeq[val1] + inputSeq[val2]
                2 -> inputSeq[val1] * inputSeq[val2]
                else -> return -1
            }

        }

        return 0
    }

    fun part2(input: String):Int {
        return 0
    }

    fun test1() {
        if (part1("1,0,0,0,99") == 2) println ("Test1 done")
        if(part1("2,3,0,3,99") == 2) println ("Test2 done")
        if(part1("2,4,4,5,99,0") == 2) println ("Test3 done")
        if(part1("1,1,1,4,99,5,6,0,99") == 30) println ("Test4 done")
    }

}

fun main(args: Array<String>) {
    Day02.start()
}