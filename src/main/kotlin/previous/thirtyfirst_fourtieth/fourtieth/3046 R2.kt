package thirtyfirst_fourtieth.fourtieth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b) = br.readLine().split(' ').map{it.toLong()}
    println(2*b-a)



}