package ch.omni.aoc.year2017

import readFile
import java.math.BigDecimal

object Day18 {

    fun start() {
        val input = readFile(18)
        val commands = input.split("\n")
        val registers: MutableMap<String, BigDecimal> = mutableMapOf()
        var frequency = BigDecimal.ZERO
        var i = 0
        while (i < commands.size) {
            println(commands[i])
            val parts = commands[i].split(" ")
            val command = parts[0]
            val first = registers.getOrDefault(parts[1], BigDecimal(parts[1].toIntOrNull() ?: 0))
            var second = BigDecimal.ZERO
            if (parts.size > 2) {
                second = registers.getOrDefault(parts[2], BigDecimal(parts[2].toIntOrNull() ?: 0))
            }
            var stop = false
            var jump = false
            when (command) {
                "snd" -> {
                    frequency = first
                    println(frequency)
                }
                "set" -> {
                    registers.put(parts[1], second)
                }
                "add" -> {
                    registers.put(parts[1], first + second)
                }
                "mul" -> {
                    registers.put(parts[1], first * second)
                }
                "mod" -> {
                    if (second > 0){
                        registers.put(parts[1], first%second)
                    }
                }
                "rcv" -> {
                    if (!first.equals(BigDecimal.ZERO)){
                        println("stop")
                        println(frequency)
                        stop = true
                    }
                }
                "jgz" -> {
                    if (first.compareTo(BigDecimal.ZERO)>=1){
                        i = i+second.toInt()
                        jump = true
                    }
                }

            }
            println(registers)
            if (stop) break
            if(jump) continue
            i++
        }


    }
}

fun main(args: Array<String>) {
    Day18.start()
}