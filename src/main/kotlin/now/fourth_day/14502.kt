package now.fourth_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var arr = Array(n){Array(m){0} }
    var visit = Array(n){Array(m){false} }
    val virus = mutableListOf<Pair<Int,Int>>()

    val dx = arrayOf(1, 0, 0, -1)
    val dy = arrayOf(0, 1, -1, 0)

    repeat(n){
        val input = br.readLine().split(" ").map { it.toInt() }
        for (index in 0 until m){
            val value = input[index]
            arr[it][index] = value
            if (value == 1){
                visit[it][index] = true
            }
            else if (value == 2){
                visit[it][index] = true
                virus.add(Pair(it,index))
            }
        }
    }
    var max = 0

    fun copyMap(array: Array<Array<Int>>): Array<Array<Int>>{
        val tempArray = Array(n){Array(m){0} }
        for (i in 0 until n){
            for (j in 0 until m){
                tempArray[i][j] = array[i][j]
            }
        }
        return tempArray
    }

    fun copyVisit(array: Array<Array<Boolean>>): Array<Array<Boolean>>{
        val tempArray = Array(n){Array(m){false} }
        for (i in 0 until n){
            for (j in 0 until m){
                tempArray[i][j] = array[i][j]
            }
        }
        return tempArray
    }

    fun bfs(){
        val tempMap = copyMap(arr)
        val tempVisit = copyVisit(visit)
        var count = 0
        val queue = LinkedList<Pair<Int,Int>>()
        virus.forEach {
            queue.add(it)
        }

        while(queue.isNotEmpty()){
            val prev = queue.poll()
            for (index in 0 until 4){
                val next = Pair(prev.first + dx[index], prev.second + dy[index])
                if (next.first < 0 || next.first >= n || next.second < 0 || next.second >= m) continue
                if (visit[next.first][next.second]) continue
                arr[next.first][next.second] = 2
                visit[next.first][next.second] = true
                queue.add(next)
            }
        }
        for (i in 0 until n){
            for (j in 0 until m){
                if (arr[i][j] == 0){
                    count ++
                }
            }
        }
        max = Math.max(max, count)
        arr = copyMap(tempMap)
        visit = copyVisit(tempVisit)
    }

    fun dfs(depth: Int){
        if (depth == 3){
            bfs()
            return
        }
        for (i in 0 until n){
            for (j in 0 until m){
                if (visit[i][j] || arr[i][j] == 1 || arr[i][j] == 2) continue
                visit[i][j] = true
                arr[i][j] = 1
                dfs(depth + 1)
                arr[i][j] = 0
                visit[i][j] = false
            }
        }
    }
    dfs(0)
    println(max)

}