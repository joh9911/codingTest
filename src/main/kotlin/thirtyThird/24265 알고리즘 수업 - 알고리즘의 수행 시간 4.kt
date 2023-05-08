package thirtyThird
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()

    println(n*(n-1)/2)
    println(2)

}