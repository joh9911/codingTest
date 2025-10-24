package now.fourth_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(n){Array(n){0} }
    val virus = mutableListOf<Pair<Int,Int>>()
    val virusSelection = Array(m){0}
    var count = n*n

    val dx = arrayOf(1, 0, 0, -1)
    val dy = arrayOf(0, 1, -1, 0)


    for (i in 0 until n){
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until n){
            val value = input[j]
            if (value == 1){
                map[i][j] = -1
                count --
            }
            else if (value == 2){
                map[i][j] = 0
                virus.add(Pair(i,j))
            }
            else{
                map[i][j] = 0
            }
        }
    }

    val virusSize = virus.size

    fun copyMap(array: Array<Array<Int>>): Array<Array<Int>>{
        val tempMap = Array(n){Array(n){0} }
        for (i in 0 until n){
            for (j in 0 until n){
                tempMap[i][j] = array[i][j]
            }
        }
        return tempMap
    }

    var min = n * n

    fun bfs(array: Array<Array<Int>>, count: Int){
        var max = 0
        var realCount = 0
        val visit = Array(n){Array(n){false} }
        val queue = LinkedList<Pair<Int,Int>>()
        virusSelection.forEach {
            val virusPo = virus[it]
            queue.add(virusPo)
            visit[virusPo.first][virusPo.second] = true
        }
//        println(queue)

        while(queue.isNotEmpty()){
            val prev = queue.poll()
            for (index in 0 until 4){
                val next = Pair(prev.first + dx[index], prev.second + dy[index])
                if (next.first < 0 || next.first >= n || next.second < 0 || next.second >= n) continue
                if (visit[next.first][next.second]) continue
                if (array[next.first][next.second] == -1) continue
                array[next.first][next.second] = array[prev.first][prev.second] + 1
                max = Math.max(max, array[next.first][next.second])
                visit[next.first][next.second] = true
                queue.add(next)
                realCount ++
            }
        }

//        for (i in 0 until n){
//            for (j in 0 until n){
//                print("${array[i][j]} ")
//            }
//            println()
//        }
//        println(max)

        if (count == realCount)
            min = Math.min(min, max)

    }


    fun dfs(depth: Int, num: Int){
        if (depth == m){
            bfs(copyMap(map), count - m)
            return
        }

        for (index in num until virusSize){
            virusSelection[depth] = index
            dfs(depth + 1, index + 1)
        }
    }
    dfs(0, 0)

    if (min == n*n)
        println(-1)
    else
        println(min)
}