import java.lang.Exception

fun main(args: Array<String>) {
    val pythonRunner = PythonRunner("src/main/python/test.py")

    try {
        val bufferReader = pythonRunner.runPythonFile()
        println(bufferReader.readLine())
    } catch (e: Exception) {
        println("Python file loading fail")
    }
}