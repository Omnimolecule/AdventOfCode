package ch.omni.aoc.year2017

object Day14 {
    val originalInput = "wenycdww"


    fun start(){
        val inputStrings = listOf(0..127).flatten().map { originalInput+"-"+it }
        val inputLengths = inputStrings.map {it.toCharArray().map { it.toInt() }}
        var free = 0
        for (inputLentgth in inputLengths){
            val denseHash = Day10.makeKnotHash(inputLentgth)
            val binString = denseHash.map{it.toString(2).format("%4s").replace(" ", "0")}.joinToString("")
            val used = binString.split("1").count()-1
            //I need to find out how many zeroes need to be added per converted value
            println(binString)
            free += used
        }
        println(free)
    }
}

fun main(args: Array<String>) {
    Day14.start()
}