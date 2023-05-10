package thirtyfirst_fourtieth.thirtyfifth
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b) = br.readLine().split(' ').map{it.toInt()}
    if (100*a >= b)
        println("Yes")
    else
        println("No")
}