package ch.omni.aoc.year2019

import gcd
import readFile

object Day10 {

    fun start() {
        val input = readFile(2019, 10).split("\n").map { it.toCharArray() }
        part1(input)
    }

    fun part1(input: List<CharArray>) {
        val results: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
        for (yIdx in input.indices) {
            for (xIdx in input[yIdx].indices) {
                if (input[yIdx][xIdx] == '#') {
                    results[Pair(xIdx, yIdx)] = checkVisiblePlanets(xIdx, yIdx, input)
                }
            }
        }
        println(results.maxBy { it.value })
    }

    private fun checkVisiblePlanets(xIdx: Int, yIdx: Int, input: List<CharArray>): Int {
        val gradient = mutableSetOf<Pair<Int, Int>>()
        for (y in input.indices) {
            for (x in input[y].indices) {
                if (x == xIdx && y == yIdx) continue
                if (input[y][x] == '#') {
                    val yDiff = (yIdx - y)
                    val xDiff = (xIdx - x)
                    val divisor = gcd(yDiff, xDiff)
                    if (divisor != 0) {
                        gradient.add(Pair(xDiff / divisor, yDiff / divisor))
                    } else {
                        gradient.add(Pair(xDiff, yDiff))
                    }
                }
            }
        }
        return gradient.size
    }

    fun test1() {
        val test1 = (".#..#\n" +
                ".....\n" +
                "#####\n" +
                "....#\n" +
                "...##").split("\n").map { it.toCharArray() }

        val test2 = ("......#.#.\n" +
                "#..#.#....\n" +
                "..#######.\n" +
                ".#.#.###..\n" +
                ".#..#.....\n" +
                "..#....#.#\n" +
                "#..#....#.\n" +
                ".##.#..###\n" +
                "##...#..#.\n" +
                ".#....####").split("\n").map { it.toCharArray() }

        val test3 = ("#.#...#.#.\n" +
                ".###....#.\n" +
                ".#....#...\n" +
                "##.#.#.#.#\n" +
                "....#.#.#.\n" +
                ".##..###.#\n" +
                "..#...##..\n" +
                "..##....##\n" +
                "......#...\n" +
                ".####.###.").split("\n").map { it.toCharArray() }

        val test4 = (".#..#..###\n" +
                "####.###.#\n" +
                "....###.#.\n" +
                "..###.##.#\n" +
                "##.##.#.#.\n" +
                "....###..#\n" +
                "..#.#..#.#\n" +
                "#..#.#.###\n" +
                ".##...##.#\n" +
                ".....#.#..").split("\n").map { it.toCharArray() }

        val test5 = (".#..##.###...#######\n" +
                "##.############..##.\n" +
                ".#.######.########.#\n" +
                ".###.#######.####.#.\n" +
                "#####.##.#.##.###.##\n" +
                "..#####..#.#########\n" +
                "####################\n" +
                "#.####....###.#.#.##\n" +
                "##.#################\n" +
                "#####.##.###..####..\n" +
                "..######..##.#######\n" +
                "####.##.####...##..#\n" +
                ".#####..#.######.###\n" +
                "##...#.##########...\n" +
                "#.##########.#######\n" +
                ".####.#.###.###.#.##\n" +
                "....##.##.###..#####\n" +
                ".#.#.###########.###\n" +
                "#.#.#.#####.####.###\n" +
                "###.##.####.##.#..##").split("\n").map { it.toCharArray() }
        part1(test1)
        part1(test2)
        part1(test3)
        part1(test4)
        part1(test5)
    }
}

fun main(args: Array<String>) {
    Day10.start()
}