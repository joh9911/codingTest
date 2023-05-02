package twentyFirst_thirtyth.`twenty first Day`

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){0}
    repeat(n){
        arr[it] = br.readLine().toInt()
    }
    val dp = Array(n){0}
    if (n > 2){
        dp[0] = arr.first()
        dp[1] = dp[0] + arr[1]
        dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2])
    }

    else if (n > 1){
        dp[0] = arr.first()
        dp[1] = arr[0] + arr[1]
    }
    else if (n == 1){
        dp[0] = arr.first()
    }
    for (index in 3 until n){
        dp[index] = Math.max(arr[index] + arr[index - 1] + dp[index - 3],
            arr[index] + dp[index- 2])
    }
    println(dp[n-1])

} // 10 20 25 20
// 10 15 25 20
// 20 15 10 20
// 10 15 10 20
// 1 1 1 1 1 1 1 1