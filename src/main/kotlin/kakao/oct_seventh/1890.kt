package kakao.oct_seventh

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = Array(n){IntArray(n)}
    val dp = Array(n){Array(n){-1L} }
    for (i in 0 until n){
        val input = br.readLine().split(' ')
        for (j in input.indices){
            map[i][j] = input[j].toInt()
        }
    }

    fun dfs(y: Int, x: Int): Long{
        if (y == n - 1 && x == n - 1) return 1

        if (map[y][x] == 0) return 0

        if (dp[y][x] != -1L) return dp[y][x]

        dp[y][x] = 0

        val value = map[y][x]
        val dy = arrayOf(value, 0)
        val dx = arrayOf(0, value)

        for (index in 0 until 2){
            val nx = x + dx[index]
            val ny = y + dy[index]

            if (nx in 0 until n && ny in 0 until n){
                dp[y][x] += dfs(ny, nx)
            }
        }
        return dp[y][x]
    }
    dfs(0, 0)
    println(dp[0][0])
}