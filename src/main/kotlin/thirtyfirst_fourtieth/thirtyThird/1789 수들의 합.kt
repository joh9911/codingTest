package thirtyfirst_fourtieth.thirtyThird
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    var num = 0L
    for (index in 1..n){
        num += index
        if (n - num <= index){
            println(index)
            break
        }
    }
}