import java.io.InputStream
import kotlin.math.absoluteValue

fun readFile(day:Int): String {
    val inputStream: InputStream = ClassLoader.getSystemResourceAsStream("input$day.txt")
    var stream =  inputStream.bufferedReader().use { it.readText() }
    stream = stream.replace("\r", "")
    stream = stream.replace("\t", " ")
    return stream
}

fun readFile(year: Int, day: Int): String {
    val inputStream: InputStream = ClassLoader.getSystemResourceAsStream("$year/input$day.txt")
    var stream = inputStream.bufferedReader().use { it.readText() }
    stream = stream.replace("\r", "")
    stream = stream.replace("\t", " ")
    return stream
}

//fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

fun gcd(a: Int, b: Int): Int {
    if (a == 0) return b.absoluteValue
    if (b == 0) return a.absoluteValue

    var newA = a
    var newB = b

    do {
        val h = newA % newB
        newA = newB
        newB = h
    } while (newB != 0)

    return newA.absoluteValue
}