package thirtyfirst_fourtieth.fourtieth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toLong()
    var num = 1L
    for (index in 0 until 3) num *= a
    println(num)
    println(3)


}