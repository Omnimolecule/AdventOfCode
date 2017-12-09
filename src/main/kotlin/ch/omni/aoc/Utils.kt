import java.io.InputStream

fun readFile(day:Int): String {
    val inputStream: InputStream = ClassLoader.getSystemResourceAsStream("input$day.txt")
    var stream =  inputStream.bufferedReader().use { it.readText() }
    stream = stream.replace("\r", "")
    stream = stream.replace("\t", " ")
    return stream
}