package ch.omni.aoc.year2017

import readFile

object Day13 {
    fun start() {
        val input = readFile(13).split("\n")
        val firewalls = input.map { it.split(": ") }.associateBy({ it.get(0).toInt() }, { Firewall(it.get(0).toInt(),it.get(1).toInt()) })
        var severity = Int.MAX_VALUE
        var delay = 10
        while (severity != 0){
            firewalls.forEach { it.value.position = 0 }
            for (i in 0..(delay-1)){
                firewalls.forEach { it.value.plusOne() }
            }
            severity = 0
            for (i in 0..firewalls.keys.last()) {
                val firewall = firewalls.get(i)

                if (firewall != null && firewall.position == 0){
                    severity += firewall.depth * firewall.layer
                }
                firewalls.forEach { it.value.plusOne() }
            }
            println(delay)
            delay++
        }

        println(delay)
    }
}

fun main(args: Array<String>) {
    Day13.start()
}

class Firewall(var layer:Int, var depth:Int){
    var position = 0
    var down = true

    fun plusOne(){
        if (down){
            if (position == (depth-1)){
                down = false
                position--
            } else {
                position++
            }
        } else {
            if (position == 0){
                down = true
                position++
            } else {
                position--
            }
        }
    }
}