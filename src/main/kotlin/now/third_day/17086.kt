package now.third_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n){Array(m){0} }
    val visit = Array(n){Array(m){false} }
    val sharks = mutableListOf<Pair<Int,Int>>()
    val dx = arrayOf(1, 1, 1, 0, 0, -1 ,-1 ,-1)
    val dy = arrayOf(1, -1, 0, 1, -1, 1, -1, 0)
    repeat(n){
        val input = br.readLine().split(" ").map { it.toInt() }
        for (index in 0 until m){
            val num = input[index]
            arr[it][index] = input[index]
            if (num == 1)
                sharks.add(Pair(it,index))
        }
    }

    fun bfs(): Int{
        val queue = LinkedList<Pair<Int,Int>>()
        sharks.forEach {
            queue.add(it)
            visit[it.first][it.second] = true
        }
        while (queue.isNotEmpty()){
            val prev = queue.poll()
            for (index in 0 until 8){
                val next = Pair(prev.first + dx[index], prev.second + dy[index])

                if (next.first < 0 || next.first >= n || next.second < 0 || next.second >= m) continue
                if (visit[next.first][next.second]) continue

                arr[next.first][next.second] = arr[prev.first][prev.second] + 1
                visit[next.first][next.second] = true
                queue.add(next)
            }
        }
        return 0
    }

    bfs()
    var max = 0
    for (i in 0 until n){
        for (j in 0 until m){
            max = Math.max(arr[i][j], max)
        }
    }
    println(max - 1)



}