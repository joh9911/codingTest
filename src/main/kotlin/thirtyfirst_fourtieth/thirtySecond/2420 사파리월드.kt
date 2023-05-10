package thirtyfirst_fourtieth.thirtySecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b) = br.readLine().split(' ').map{it.toLong()}
    println(Math.abs(a-b))
}