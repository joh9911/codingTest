package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n, h) = br.readLine().split(" ").map{it.toInt()}

    val arr = Array(h){Array(n){Array(m){0} } }

    var zeroCount = 0
    val tomatoes = mutableListOf<Triple<Int,Int,Int>>()
    repeat(h){
        for (i in 0 until n){
            val input = br.readLine().split(" ").map{it.toInt()}
            for (j in 0 until m){
                val num = input[j].toString().toInt()
                arr[it][i][j] = num
                if (num == 1)
                    tomatoes.add(Triple(it,i,j))
                else if (num == 0)
                    zeroCount ++
            }
        }
    }

    val dx = arrayOf(1, 0, 0, 0, 0, -1)
    val dy = arrayOf(0, 1,-1, 0, 0, 0)
    val dz = arrayOf(0, 0, 0, 1, -1, 0)

    var days = 0
    fun bfs(){
        val queue = LinkedList<Triple<Int,Int,Int>>()
        for (index in tomatoes.indices){
            queue.add(tomatoes[index])
        }

        while (queue.isNotEmpty()){
            val prev = queue.poll()

            for (index in 0 until 6){
                val nextMove = Triple(prev.first + dz[index], prev.second + dx[index], prev.third + dy[index])

                if (nextMove.first < 0 || nextMove.second < 0 || nextMove.third < 0 || nextMove.first >= h || nextMove.second >= n || nextMove.third >= m) continue

                if (arr[nextMove.first][nextMove.second][nextMove.third] == 0){
                    arr[nextMove.first][nextMove.second][nextMove.third] = arr[prev.first][prev.second][prev.third] + 1
                    days = arr[nextMove.first][nextMove.second][nextMove.third]
                    zeroCount --
                    queue.add(nextMove)
                }
            }

        }
    }
    if (zeroCount == 0){
        println(0)
    }
    else{
        bfs()
        if (zeroCount == 0){
            println(days - 1)
        }
        else{
            println(-1)
        }
    }




}