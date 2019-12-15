package ch.omni.aoc.year2019

import kotlin.math.absoluteValue

object Day12 {

    fun start() {
        val planets = listOf(
                Planet(-17, 9, -5),
                Planet(-1, 7, 13),
                Planet(-19, 12, 5),
                Planet(-6, -6, -4)
        )
        part1(planets, 1000)

    }

    fun part1(planets: List<Planet>, toTime: Int) {
        for (time in 1..toTime) {
            for (p1Idx in 0 until planets.size) {
                for (p2Idx in p1Idx + 1 until planets.size) {
                    planets[p1Idx].updateVelocity(planets[p2Idx])
                }
            }

            println("After $time Steps:")
            for (planet in planets) {
                planet.applyVelocity()
                println(planet)
            }
            println()

        }

        val energySum = planets.map { it.calculateEnergy() }.sum()
        println("Sum of Energy: $energySum")
    }

    fun test1() {
        val planets = listOf(
                Planet(-1, 0, 2),
                Planet(2, -10, -7),
                Planet(4, -8, 8),
                Planet(3, 5, -1)
        )
        part1(planets, 10)

        val planets2 = listOf(
                Planet(-8, -10, 0),
                Planet(5, 5, 10),
                Planet(2, -7, 3),
                Planet(9, -8, -3)
        )

        part1(planets2, 100)

    }

    class Planet(var pX: Int, var pY: Int, var pZ: Int) {
        var vX: Int = 0
        var vY: Int = 0
        var vZ: Int = 0

        fun updateVelocity(planetTwo: Planet) {
            if (pX > planetTwo.pX) {
                vX--
                planetTwo.vX++
            } else if (pX < planetTwo.pX) {
                vX++
                planetTwo.vX--
            }

            if (pY > planetTwo.pY) {
                vY--
                planetTwo.vY++
            } else if (pY < planetTwo.pY) {
                vY++
                planetTwo.vY--
            }

            if (pZ > planetTwo.pZ) {
                vZ--
                planetTwo.vZ++
            } else if (pZ < planetTwo.pZ) {
                vZ++
                planetTwo.vZ--
            }
        }

        fun applyVelocity() {
            pX += vX
            pY += vY
            pZ += vZ
        }

        fun calculateEnergy(): Int {
            val potEnergy = pX.absoluteValue + pY.absoluteValue + pZ.absoluteValue
            val kinEnergy = vX.absoluteValue + vY.absoluteValue + vZ.absoluteValue
            return potEnergy * kinEnergy
        }

        override fun toString(): String {
            return "pos = <x = $pX, y = $pY, z = $pZ> vel = <x = $vX, y = $vY, z = $vZ>"
        }
    }
}


fun main(args: Array<String>) {
    Day12.start()
}