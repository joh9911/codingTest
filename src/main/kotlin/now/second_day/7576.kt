package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n){Array(m){0} }
    val visit = Array(n){Array(m){false} }
    val location = mutableListOf<Pair<Int,Int>>()
    val xList = arrayOf(1, 0, 0, -1)
    val yList = arrayOf(0, 1, -1, 0)
    repeat(n){
        val input = br.readLine().split(" ").map { it.toInt() }
        for (index in 0 until m){
            val tomato = input[index]
            arr[it][index] = tomato
            if (tomato == -1)
                visit[it][index] = true
            else if (tomato == 1)
                location.add(Pair(it,index))
        }
    }

    fun bfs(){
        val queue = LinkedList<Pair<Int,Int>>()
        location.forEach {
            queue.add(it)
            visit[it.first][it.second] = true
        }
        while (queue.isNotEmpty()){
            val prev = queue.poll()
            for (index in 0 until 4){
                val next = Pair(prev.first + xList[index], prev.second + yList[index])

                if (next.first < 0 || next.first >= n || next.second < 0 || next.second >= m) continue
                if (visit[next.first][next.second]) continue
                visit[next.first][next.second] = true
                arr[next.first][next.second] = arr[prev.first][prev.second] + 1
                queue.add(next)
            }
        }
    }
    bfs()
    var max = 0
    var tag = false
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 0)
                tag = true
            max = Math.max(max, arr[i][j])
        }
    }
    if (tag)
        println(-1)
    else
        println(max - 1)

}