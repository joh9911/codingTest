package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n){
        val word = br.readLine()
        val pair = isRecursion(word, 0, word.length-1, 1)
        println("${pair.first} ${pair.second}")
    }
}
fun isRecursion(string: String, start: Int, last: Int,c: Int): Pair<Int, Int> {
    var count = c
    return if (start >= last) Pair(1, c)
    else if (string[start] != string[last]) Pair(0, c)
    else isRecursion(string, start + 1, last - 1, count + 1)
}