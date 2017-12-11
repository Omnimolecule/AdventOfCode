package ch.omni.aoc.year2017

fun main(args: Array<String>) {
    val inputs = input4.split("\n")
    var result = inputs.size
    println(result)
    for (line in inputs) {
        val set: MutableSet<String> = mutableSetOf()
        for (word in line.split(" ")) {
            val newWord = word.toCharArray()
            newWord.sort();
            val wordString: String = newWord.joinToString("")
            if (!set.add(wordString)) {
                result--
                break;
            }
        }
    }
    println(result)
}