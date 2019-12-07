package ch.omni.aoc.year2019

object IntcodeComputer {

    fun calculate(input: List<Int>): Pair<List<Int>, List<Int>> {
        return calculate(input, null, null)
    }

    fun calculate(input: List<Int>, inputs: List<Int>): Pair<List<Int>, List<Int>> {
        return calculate(input, null, null, inputs)
    }

    fun calculate(input: List<Int>, verb: Int?, noun: Int?, inputs: List<Int> = listOf()): Pair<List<Int>, List<Int>> {
        val newList = input.map { it }.toMutableList()
        val outList = mutableListOf<Int>()
        var inputIdx = 0

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
            if (opcode == 99) return Pair(newList, outList)

            when (opcode) {
                99 -> {
                    println("Done 99")
                    return Pair(newList, outList)
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
                    if (inputs.isNotEmpty()) {
                        newList[val1] = inputs[inputIdx]
                        inputIdx++
                    } else {
                        println("Input please:")
                        newList[val1] = readLine()!!.toInt()
                    }
                    i += 2
                }
                4 -> {
                    val val1 = newList[i + 1]
                    val firstParam = getParameter(modeParam1, newList, val1)
                    outList.add(firstParam)
                    println("Output: ${firstParam}")
                    i += 2
                }
                5 -> {
                    val val1 = newList[i + 1]
                    val val2 = newList[i + 2]
                    val firstParam = getParameter(modeParam1, newList, val1)
                    val secondParam = getParameter(modeParam2, newList, val2)
                    if (firstParam > 0) {
                        i = secondParam
                    } else {
                        i += 3
                    }
                }
                6 -> {
                    val val1 = newList[i + 1]
                    val val2 = newList[i + 2]
                    val firstParam = getParameter(modeParam1, newList, val1)
                    val secondParam = getParameter(modeParam2, newList, val2)
                    if (firstParam == 0) {
                        i = secondParam
                    } else {
                        i += 3
                    }
                }
                7 -> {
                    val val1 = newList[i + 1]
                    val val2 = newList[i + 2]
                    val res = newList[i + 3]
                    val firstParam = getParameter(modeParam1, newList, val1)
                    val secondParam = getParameter(modeParam2, newList, val2)
                    if (modeParam3 == 1) {
                        error("write instructions can never be in immediate mode")
                    }
                    newList[res] = when {
                        firstParam < secondParam -> 1
                        else -> 0
                    }
                    i += 4
                }
                8 -> {
                    val val1 = newList[i + 1]
                    val val2 = newList[i + 2]
                    val res = newList[i + 3]
                    val firstParam = getParameter(modeParam1, newList, val1)
                    val secondParam = getParameter(modeParam2, newList, val2)
                    if (modeParam3 == 1) {
                        error("write instructions can never be in immediate mode")
                    }
                    newList[res] = when (firstParam) {
                        secondParam -> 1
                        else -> 0
                    }
                    i += 4
                }
                else -> {
                    println("Done $opcode")
                    return Pair(newList, outList)
                }
            }
        }
        println("Done End")
        return Pair(listOf(), listOf())
    }

    private fun getParameter(mode: Int, inputList: List<Int>, value: Int): Int {
        return when (mode) {
            0 -> inputList[value]
            1 -> value
            else -> error("wrong parameter")
        }
    }
}