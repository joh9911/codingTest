package kakao.oct_seventh

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()

    val dp = Array(num + 1){0L}
    dp[0] = 0
    dp[1] = 1
    for (index in 2..num){
        dp[index] = dp[index - 1].toLong() + dp[index - 2].toLong()
    }

    println(dp[num])
}