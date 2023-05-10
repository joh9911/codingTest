package thirtyfirst_fourtieth.thirtysixth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val location = Array(n){Array(n){0} }
    val dp = Array(n){Array(n){0L}}
    val visit = Array(n){Array(n){false} }
    repeat(n){
        val token = StringTokenizer(br.readLine())
        for (index in 0 until n){
            location[it][index] = token.nextToken().toInt()
        }
    }

    dp[0][0] = 1L
    for (y in 0 until n){
        for (x in 0 until n){
            val locationValue = location[y][x]
            if (locationValue == 0 || (y == n-1 && x == n-1) )
                continue
            if (locationValue + x <= n-1)
                dp[y][locationValue + x] += dp[y][x]
            if (locationValue + y <= n-1)
                dp[locationValue+y][x] += dp[y][x]
        }
    }
    println(dp[n-1][n-1])
}