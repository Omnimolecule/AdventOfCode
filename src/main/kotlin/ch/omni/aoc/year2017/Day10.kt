package ch.omni.aoc.year2017

import readFile

object Day10 {
    val hash = listOf(0..255).flatten().toMutableList()
    val inputLength = readFile(10).split(",").map{it.toInt()}
    fun start() {
        var idx = 0
        var skipSize = 0
        for (length in inputLength) {
            val area = mutableListOf<Pair<Int, Int>>()

            for (i in idx..(idx + length)-1) {
                if (i < hash.size){
                    area.add(Pair(i, hash.get(i)))
                } else {
                    area.add(Pair(i%hash.size, hash.get(i%hash.size)))
                }
            }
            val reversedArea = area.reversed()
            reversedArea.forEachIndexed { index, value ->
                hash.set(area.get(index).first, value.second)
            }
            idx += (skipSize + length)
            idx = idx % hash.size
            skipSize++
        }
        println(hash.get(0) * hash.get(1))
    }
}

fun main(args: Array<String>) {
    Day10.start()
}
