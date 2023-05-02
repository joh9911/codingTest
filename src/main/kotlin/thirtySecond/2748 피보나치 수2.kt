package thirtySecond
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = Array(91){0L}
    dp[0] = 0
    dp[1] = 1
    for (index in 2..n){
        dp[index] = dp[index-1].toLong() + dp[index-2].toLong()
    }
    println(dp[n])
}