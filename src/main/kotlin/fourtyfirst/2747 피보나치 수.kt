package fourtyfirst
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = Array(n+1){0L}
    dp[0] = 0
    dp[1] = 1
    for (index in 2..n){
        dp[index] = dp[index - 1] + dp[index - 2]
    }
    println(dp[n])
}
