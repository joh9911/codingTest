package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val arr = Array(n + 1){ mutableListOf<Int>() }
    val visit = Array(n + 1){false}
    repeat(m){
        val (a, b) = br.readLine().split(" ").map{it.toInt()}
        arr[a].add(b)
        arr[b].add(a)
    }
    var count = 0

    fun bfs(){
        val queue = LinkedList<Int>()
        queue.add(1)
        visit[1] = true
        while (queue.isNotEmpty()){
            val node = queue.poll()
            for (index in arr[node].indices){
                if (visit[arr[node][index]]) continue
                count ++
                visit[arr[node][index]] = true
                queue.add(arr[node][index])
            }
        }
    }
    bfs()
    println(count)
}