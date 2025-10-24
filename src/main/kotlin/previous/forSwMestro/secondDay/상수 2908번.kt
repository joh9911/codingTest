package secondDay
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    if (calculator(n) > calculator(m))
        println(calculator(n))
    else
        println(calculator(m))
}
fun calculator(n: Int): Int {
    var value = n
    var f = value % 10
    value /= 10
    var s = value % 10
    value /= 10
    var t = value % 10
    return f*100 + s*10 + t

}