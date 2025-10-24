package kakao.oct_fifth

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val map = Array(n+1){IntArray(n + 1)}
    val visit = Array(n+1){Array(n+1){false} }

    val xList = arrayOf(0, 0, 1, -1)
    val yList = arrayOf(1, -1, 0, 0)

    var count = 0
    val answer = mutableListOf<Int>()

    fun dfs(x: Int, y: Int){
        count ++
        visit[x][y] = true
        for (index in 0 until 4){
            val nextX = xList[index] + x
            val nextY = yList[index] + y

            if (nextX < 0 || nextX >= n) continue
            if (nextY < 0 || nextY >= n) continue

            if (map[nextX][nextY] == 1 && !visit[nextX][nextY]){
                dfs(nextX, nextY)
            }
        }
    }

    repeat(n){
        val input = br.readLine()
        for (index in input.indices){
            map[it][index] = input[index].toString().toInt()
        }
    }

    for (i in map.indices){
        for (j in map[i].indices){
            if (map[i][j] == 1 && !visit[i][j]){
                dfs(i, j)
                answer.add(count)
                count = 0
            }
        }
    }
    println(answer.size)
    answer.sorted().forEach {
        println(it)
    }
}