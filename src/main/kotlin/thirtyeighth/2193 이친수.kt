package thirtyeighth
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = Array(n + 1) { 0.toBigInteger() }

    dp[1] = 1.toBigInteger()
    if (n==1)
        println(dp[n])
    else{
        dp[2] = 1.toBigInteger()
        for (index in 3..n) {
            dp[index] = dp[index - 1] + dp[index - 2]
        }
        println(dp[n])
    }

}