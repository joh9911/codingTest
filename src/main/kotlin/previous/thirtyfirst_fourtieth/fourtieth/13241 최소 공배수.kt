package thirtyfirst_fourtieth.fourtieth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b) = br.readLine().split(' ').map{it.toLong()}
    fun gcd(a: Long,b: Long): Long {
        if (b == 0L) return a
        else return gcd(b, a%b)
    }
    println(a*b/gcd(a,b))



}