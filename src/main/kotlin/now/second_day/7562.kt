package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCase = br.readLine().toInt()

    val dx = arrayOf(1, 1, 2, 2, -1, -1 ,-2 ,-2)
    val dy = arrayOf(2, -2, 1, -1, 2, -2, 1, -1)



    repeat(testCase){
        val n = br.readLine().toInt()
        val arr = Array(n){Array(n){0} }
        val (a,b) = br.readLine().split(" ").map { it.toInt() }
        arr[a][b] = 1
        val (c,d) = br.readLine().split(" ").map { it.toInt() }
        fun bfs(): Int{
            val queue = LinkedList<Pair<Int,Int>>()
            queue.add(Pair(a,b))
            var max = 1
            while(queue.isNotEmpty()){
                val prev = queue.poll()
                var tag = false
                for (index in 0 until 8){
                    val next = Pair(prev.first + dx[index], prev.second + dy[index])
                    if (next.first < 0 || next.first >= n || next.second < 0 || next.second >= n) continue
                    if (arr[next.first][next.second] == 0){
                        arr[next.first][next.second] = arr[prev.first][prev.second] + 1
                        if (next.first == c && next.second == d){
                            max = arr[next.first][next.second]
                            tag = true
                            break
                        }
                        queue.add(next)
                    }
                }
                if (tag)
                    break
            }
            return max - 1
        }
        println(bfs())
//        for (i in 0 until n){
//            for (j in 0 until n){
//                print(arr[i][j])
//            }
//            println()
//        }
    }
}