package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(factorial(br.readLine().toInt()))
}
fun factorial(n: Int): Int = when(n){
    0 -> 1
    else -> n * factorial(n-1)
}