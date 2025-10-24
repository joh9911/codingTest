package kakao.oct_seventh

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val dp = Array(n + 1){0}
    dp[1] = 0

    if (n == 1){
        println(0)
    } else if(n == 2){
        println(1)
    } else if (n == 3){
        println(1)
    }
    else{
        dp[2] = 1
        dp[3] = 1
        for (index in 4 .. n){
            var min = Int.MAX_VALUE
            if (index % 3 == 0){
                val value = index / 3
                min = minOf(min, dp[value])
            }
            if (index % 2 == 0){
                val value = index / 2
                min = minOf(min, dp[value])
            }
            min = minOf(min, dp[index - 1])
            dp[index] = min + 1
        }
        println(dp[n])
    }


}