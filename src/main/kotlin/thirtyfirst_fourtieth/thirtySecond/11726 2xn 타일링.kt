package thirtyfirst_fourtieth.thirtySecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = Array(n+1){0L}
    dp[1] = 1L
    if (n==1)
        println(dp[1])
    else{
        dp[2] = 2
        for (index in 3..n){
            dp[index] = (dp[index-1] % 10007) + (dp[index-2] % 10007)
        }
        println(dp[n] % 10007)
    }

}
// 1
// 2
// 3
// 5
// 8