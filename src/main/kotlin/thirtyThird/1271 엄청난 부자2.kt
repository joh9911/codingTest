package thirtyThird
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n,m) = br.readLine().split(' ').map{it.toBigInteger()}
    println(n / m)
    println(n % m)
}