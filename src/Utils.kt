import java.io.File
import java.io.InputStream

fun readFile(day:Int): String {
    val inputStream: InputStream = File("src/input$day.txt").inputStream()
    var stream =  inputStream.bufferedReader().use { it.readText() }
    stream = stream.replace("\r", "")
    stream = stream.replace("\t", " ")
    return stream
}