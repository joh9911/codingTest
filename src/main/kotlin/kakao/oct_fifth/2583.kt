package kakao.oct_fifth

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m,n,k) = br.readLine().split(' ').map { it.toInt() }

    val map = Array(m){ Array(n){0} }
    val visit = Array(m){ Array(n){false} }

    repeat(k){
        val (x1, y1, x2, y2) = br.readLine().split(' ').map { it.toInt() }

        for (i in y1 until y2){
            for (j in x1 until x2){
                map[i][j] = 1
            }
        }
    }

    val xList = arrayOf(1, -1, 0, 0)
    val yList = arrayOf(0, 0, 1, -1)

    fun dfs(x: Int, y: Int): Int{
        var count = 1
        visit[y][x] = true

        for (index in 0 until 4){
            val nx = x + xList[index]
            val ny = y + yList[index]

            if (nx < 0 || nx >= n) continue
            if (ny < 0 || ny >= m) continue
            if (map[ny][nx] == 0 && !visit[ny][nx]){
                visit[ny][nx] = true
                count += dfs(nx, ny)
            }
        }
        return count
    }

    val answer = mutableListOf<Int>()
    for (i in map.indices){
        for (j in map[i].indices){
            if (map[i][j] == 0 && !visit[i][j]){
                val count = dfs(j, i)
                answer.add(count)
            }
        }
    }
    println(answer.size)

    answer.sorted().forEach {
        print("$it ")
    }

}