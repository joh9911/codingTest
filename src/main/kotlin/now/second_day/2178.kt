package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map{it.toInt()}

    val map = Array(n){Array(m){0} }
    val visit = Array(n){Array(m){false} }

    val xList = arrayOf(1, 0, 0, -1)
    val yList = arrayOf(0, 1, -1, 0)
    repeat(n){
        val input = br.readLine()
        for (index in input.indices){
            val num = input[index].toString().toInt()
            map[it][index] = num
            if (num == 0)
                visit[it][index] = true
        }
    }

    fun bfs(start: Pair<Int,Int>){
        val queue = LinkedList<Pair<Int,Int>>()
        queue.add(start)
        visit[start.first][start.second] = true

        while(queue.isNotEmpty()){
            val now = queue.poll()

            for (index in 0 until 4){
                val move = Pair(now.first + xList[index], now.second + yList[index])

                if (move.first < 0 || move.second < 0 || move.first >= n || move.second >= m) continue

                if (visit[move.first][move.second] || map[move.first][move.second] == 0) continue

                visit[move.first][move.second] = true
                map[move.first][move.second] = map[now.first][now.second] + 1
                queue.add(move)
            }
        }
    }
    bfs(Pair(0,0))
    println(map[n - 1][m - 1])

}