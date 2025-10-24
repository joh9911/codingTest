package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val arr = Array(n){Array(n){0} }
    val visit = Array(n){Array(n){false} }
    val dx = arrayOf(1, 0, 0, -1)
    val dy = arrayOf(0, 1, -1, 0)

    for (i in 0 until n){
        val input = br.readLine()
        for (j in 0 until n){
            val num = input[j].toString().toInt()
            arr[i][j] = num
            if (num == 0)
                visit[i][j] = true
        }
    }

    val countList = mutableListOf<Int>()

    fun bfs(start: Pair<Int, Int>): Int{
        var count = 0
        val queue = LinkedList<Pair<Int,Int>>()
        queue.add(start)
        visit[start.first][start.second] = true

        while(queue.isNotEmpty()){
            val prev = queue.poll()

            for (index in 0 until 4){
                val next = Pair(prev.first + dx[index], prev.second + dy[index])

                if (next.first < 0 || next.first >= n || next.second < 0 || next.second >= n) continue
                if (visit[next.first][next.second]) continue

                if (arr[next.first][next.second] == 1){
                    visit[next.first][next.second] = true
                    count ++
                    queue.add(next)
                }
            }
        }
        return count + 1
    }

    for (i in 0 until n){
        for (j in 0 until n){
            if (!visit[i][j] && arr[i][j] == 1){
                countList.add(bfs(Pair(i, j)))
            }
        }
    }
    println(countList.count())
    countList.sorted().forEach{
        println(it)
    }
}