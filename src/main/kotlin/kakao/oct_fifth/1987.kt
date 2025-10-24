package kakao.oct_fifth

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (R,C) = br.readLine().split(' ').map{it.toInt()}

    val map = Array(R){Array(C){' '} }
    for (i in 0 until R){
        val input = br.readLine()
        for (j in input.indices){
            map[i][j] = input[j]
        }
    }
    val visit = Array(26){false}

    val xList = arrayOf(1, -1, 0, 0)
    val yList = arrayOf(0, 0, 1, -1)

    var answer = 0

    fun dfs(x: Int, y: Int, count: Int){
        visit[map[x][y].code - 65] = true
        for (index in 0 until 4){
            val nx = x + xList[index]
            val ny = y + yList[index]

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue
            if (!visit[map[nx][ny].code - 65]){
                visit[map[nx][ny].code - 65] = true
                dfs(nx, ny, count + 1)
                answer = maxOf(answer, count)
                visit[map[nx][ny].code - 65] = false
            }
        }
        answer = maxOf(answer, count)

    }
    dfs(0, 0, 1)
    println(answer)

}