package `twenty eighth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()
    var tag = true
    for (index in string.indices){
        if (string[index] != string[string.length - index - 1])
            tag = false
    }
    if (tag)
        println(1)
    else
        println(0)
}