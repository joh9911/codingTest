package thirtyfirst_fourtieth.thirtyeighth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b,c) = br.readLine().split(' ').map{it.toInt()}
    val max = Math.max(a,Math.max(b,c))
    val sum = a+b+c
    val min = Math.min(a,Math.min(b,c))
    println(sum-max-min)

}