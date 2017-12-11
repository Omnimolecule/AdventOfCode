package ch.omni.aoc.year2017

import readFile

object Day11 {

    fun start(){
        val input = "se,sw,se,sw,sw" //readFile(11)
        val blub = input.split(",").groupingBy { it }.eachCount()
        println(blub)
        val hor = Math.abs((blub["w"]?:0).minus(blub["e"]?:0))
        val ver = Math.abs((blub["n"]?:0).minus(blub["s"]?:0))
        val diagL = Math.abs((blub["nw"]?:0).minus(blub["se"]?:0))
        val diagR = Math.abs((blub["sw"]?:0).minus(blub["ne"]?:0))

        println(hor)
        println(ver)
        println(diagL)
        println(diagR)
        println(diagL+diagR-ver-hor)
    }
}

fun main(args: Array<String>) {
    Day11.start()
}