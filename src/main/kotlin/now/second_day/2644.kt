package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n + 1){ mutableListOf<Int>() }
    val visit = Array(n + 1){false}
    val num = Array(n + 1){0}
    val (a, b) = br.readLine().split(" ").map{it.toInt()}
    val m = br.readLine().toInt()
    repeat(m){
        val (c, d) = br.readLine().split(" ").map{it.toInt()}
        arr[c].add(d)
        arr[d].add(c)
    }

    fun bfs(){
        val queue = LinkedList<Int>()
        queue.add(a)
        visit[a] = true
        num[a] = 0

        while(queue.isNotEmpty()){
            val node = queue.poll()
            for (index in arr[node].indices){
                if (visit[arr[node][index]]) continue
                visit[arr[node][index]] = true
                num[arr[node][index]] = num[node] + 1
                queue.add(arr[node][index])
            }
        }
    }
    bfs()
    if (num[b] == 0)
        println(-1)
    else
        println(num[b])
}