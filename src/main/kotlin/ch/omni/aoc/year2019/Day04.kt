package ch.omni.aoc.year2019

object Day04 {
    fun start() {
        part1(146810, 612564)
    }

    fun part1(from: Int, to: Int) {
        val result: MutableList<Int> = mutableListOf()
        for (pw in from .. to) {
            if (checkValid(pw)) {
                result.add(pw)
            }
        }
        println(result.size)
    }

    fun checkValid(pw: Int):Boolean {
        val stringPw = pw.toString()
        var lastOne = '0'
        var doubleFound = false
        for (char in stringPw){
            if (char.toInt() >= lastOne.toInt()){
                if (char.equals(lastOne)){
                    doubleFound = true
                }
            } else {
                return false
            }
            lastOne = char
        }
        return doubleFound
    }


    fun part2() {

    }

    fun test1() {
        println(checkValid(111111))
        println(checkValid(223450))
        println(checkValid(123789))
    }
}


fun main(args: Array<String>) {
    Day04.start()
}