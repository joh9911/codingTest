package thirtyfirst_fourtieth.thirtyfifth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    println((n*(n-1)*(n-2)) / 6)
    println(3)
}
