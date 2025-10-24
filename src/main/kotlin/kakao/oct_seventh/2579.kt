package kakao.oct_seventh

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n + 1){0}
    val dp = Array(n + 1){0}
    for (index in 1 .. n){
        arr[index] = br.readLine().toInt()
    }

    when (n) {
        1 -> {
            println(arr[1])
        }
        2 -> {
            println(arr[1] + arr[2])
        }
        else -> {
            dp[0] = 0
            dp[1] = arr[1]
            dp[2] = arr[1] + arr[2]
            for (index in 3 .. n){
                dp[index] = maxOf(arr[index] + arr[index - 1] + dp[index - 3], dp[index - 2] + arr[index])
            }
            println(dp[n])
        }
    }
}
