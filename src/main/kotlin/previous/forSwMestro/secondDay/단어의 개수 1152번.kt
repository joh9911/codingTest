package secondDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val wordList = br.readLine().split(' ').toMutableList()
    if (wordList[0] == "")
        wordList.removeAt(0)
    if (wordList[wordList.size - 1] == "")
        wordList.removeAt(wordList.size - 1)
    println(wordList.size)
}