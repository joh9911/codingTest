package kakao.oct_seventh

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (m, n) = br.readLine().split(' ').map { it.toInt() }
    val map = Array(m){Array(n){0} }
    val dp = Array(m){Array(n){ -1} }
    for (i in 0 until m){
        val input = br.readLine().split(' ')
        for (j in input.indices){
            map[i][j] = input[j].toInt()
        }
    }
    val xList = arrayOf(1, -1, 0, 0)
    val yList = arrayOf(0, 0, 1, -1)

    fun dfs(x: Int, y: Int): Int{
        if (x == n - 1 && y == m - 1) return 1

        if (dp[y][x] != -1) return dp[y][x]

        dp[y][x] = 0
        for (index in 0 until 4){
            val nx = xList[index] + x
            val ny = yList[index] + y

            if (nx in 0 until n && ny in 0 until m && map[y][x] > map[ny][nx]){
                dp[y][x] += dfs(nx, ny)
            }
        }
        return dp[y][x]
    }
    dfs(0, 0)
    println(dp[0][0])

}