package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    println(function(n))
}
fun function(n: Int): Int = when(n){
    0 -> 0
    1 -> 1
    else -> function(n-1) + function(n-2)
}