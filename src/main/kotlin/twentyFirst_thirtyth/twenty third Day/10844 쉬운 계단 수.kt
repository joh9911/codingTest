package twentyFirst_thirtyth.`twenty third Day`

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var start = 1
    for (index in 0 until n - 1){
        start *= 10
    }
    var end = 1
    for (index in 0 until n){
        end *= 10
    }

    val dp = Array(n+1){ Array(10){0} }

    // 0
    dp[1][0] = 0

    // 1 ~ 9
    for(j in 1 until 10){
        dp[1][j] = 1
    }

    for(i in 2 until n+1){
        for(j in 0 until 10){
            when(j){
                0 -> dp[i][j] = dp[i-1][1] // 0은 1 뒤에만 추가할 수 있음
                9 -> dp[i][j] = dp[i-1][8] // 9는 8 뒤에만 추가할 수 있음
                else -> dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1]) % 1000000000
            }
        }
    }

    var sum = 0L
    dp[n].forEach { sum += it }
    sum %= 1000000000
    println(sum)
}
//    if (n == 1)
//        println(9)
//    else if (n == 2)
//        println(17)
//    else{
//        dp[1] = 9
//        dp[2] = 17
//        dp1[1] = 1 // 1
//        dp1[2] = 1
//        for (index in 3..n){
//            dp1[index] = (index-1)*dp1[index - 1] / (index / 2) //
//            dp[index] = (dp[index - 1] * 2) - dp1[index]
//        }
//        println(dp[n] % 1000000000)
//    }
// 9 1
// 17 2    1
// 32 3    2  1
// 61 4    3  2
// 116 5   6  2
// 222 6   10 3
// 424 7   20 3
// 813 8   35 4
// 1556 9  70 4
// 2986 10 126 5
// 5720 11 252 5
// 10978     12 462 6