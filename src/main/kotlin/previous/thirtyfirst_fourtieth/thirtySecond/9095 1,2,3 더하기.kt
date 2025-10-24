package thirtyfirst_fourtieth.thirtySecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t){
        val n = br.readLine().toInt()
        val dp = Array(12){0}
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4
        for (index in 4..n){
            dp[index] = dp[index-3] + dp[index-2] + dp[index-1]
        }
        println(dp[n])

    }
}
//2 - 1 + 1

//3 - 1 + 1 + 1
//    2 + 1
//    1 + 2

//4 1 1 1 1
//  1 1 2
//  1 2 1
//  2 1 1
//  2 2
//  1 3
//  3 1

//5 1 1 1 1 1
//  1 1 1 2
//  1 2 1 1
//  2 1 1 1
//  1 1 2 1
//  2 2 1
//  2 1 2
//  1 2 2
//  3 1 1
//  1 3 1
//  1 1 3
//  2 3
//  3 2

//6 1 1 1 1 1 1   1
//  1 1 1 1 2    5
//  1 1 2 2      6
//  1 2 1 2
//  1 2 2 1
//  2 1 2 1
//  2 2 1 1
//  2 1 1 2
//  3 1 1 1      4
//  2 2 2        1
//  3 2 1        6
//  2 3 1
//  1 2 3
//  3 1 2
//  2 1 3
//  1 3 2
//  3 3          1

// 1 2 3 4 5  6
// 1 2 4 7 13 24

//2 3 4 5  6  7
//1 3 7 13 24 44

// 2 4 5 11 20