package ch.omni.aoc.year2019

import readFile

object Day07 {

    fun start() {
        val input = readFile(2019, 7).split(",").map { it.toInt() }
        println(part1(input))
    }

    fun part1(input: List<Int>): Int {
        val sequences = createSequences()
        val outputs = mutableListOf<Int>()
        for (sequence in sequences) {
            //Amp A
            println("Amp A:")
            val resultA = IntcodeComputer.calculate(input, listOf(sequence[0], 0))
            //Amp B
            println("Amp B:")
            val resultB = IntcodeComputer.calculate(input, listOf(sequence[1], resultA.second.last()))
            //Amp C
            println("Amp C:")
            val resultC = IntcodeComputer.calculate(input, listOf(sequence[2], resultB.second.last()))
            //Amp D
            println("Amp D:")
            val resultD = IntcodeComputer.calculate(input, listOf(sequence[3], resultC.second.last()))
            //Amp E
            println("Amp E:")
            val resultE = IntcodeComputer.calculate(input, listOf(sequence[4], resultD.second.last()))
            outputs.add(resultE.second.last())
        }
        return outputs.max()!!
    }

    private fun createSequences(): List<List<Int>> {
        val output = mutableSetOf<List<Int>>()
        for (n1 in 0..4) {
            for (n2 in 0..4) {
                for (n3 in 0..4) {
                    for (n4 in 0..4) {
                        for (n5 in 0..4) {
                            if (setOf(n1, n2, n3, n4, n5).size == 5) {
                                output.add(listOf(n1, n2, n3, n4, n5))
                            }
                        }
                    }
                }
            }
        }
        return output.toList()
    }

    fun test1() {
        val input1 = listOf(3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0)
        val sequence1 = listOf(4, 3, 2, 1, 0)

        val input2 = listOf(3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23,
                101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0)
        val sequence2 = listOf(0, 1, 2, 3, 4)

        val input3 = listOf(3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33,
                1002, 33, 7, 33, 1, 33, 31, 31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0)
        val sequence3 = listOf(1, 0, 4, 3, 2)

        val inputs = listOf(Pair(input1, sequence1), Pair(input2, sequence2), Pair(input3, sequence3))
        val outputs = mutableListOf<Int>()
        for (input in inputs) {
            //Amp A
            println("Amp A:")
            val resultA = IntcodeComputer.calculate(input.first, listOf(input.second[0], 0))
            //Amp B
            println("Amp B:")
            val resultB = IntcodeComputer.calculate(input.first, listOf(input.second[1], resultA.second.last()))
            //Amp C
            println("Amp C:")
            val resultC = IntcodeComputer.calculate(input.first, listOf(input.second[2], resultB.second.last()))
            //Amp D
            println("Amp D:")
            val resultD = IntcodeComputer.calculate(input.first, listOf(input.second[3], resultC.second.last()))
            //Amp E
            println("Amp E:")
            val resultE = IntcodeComputer.calculate(input.first, listOf(input.second[4], resultD.second.last()))
            outputs.add(resultE.second.last())
        }
        println(outputs)
    }
}

fun main(args: Array<String>) {
    Day07.start()
}