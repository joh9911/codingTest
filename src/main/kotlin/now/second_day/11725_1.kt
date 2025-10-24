package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val visit = Array(n + 1){false}
    val parent = Array(n + 1){0}
    val nodes = Array(n + 1){ mutableListOf<Int>() }
    repeat(n - 1){
        val (a,b) = br.readLine().split(" ").map { it.toInt() }
        nodes[a].add(b)
        nodes[b].add(a)
    }
    fun bfs(){
        val queue = LinkedList<Int>()
        queue.add(1)
        visit[1] = true

        while (queue.isNotEmpty()){
            val prev = queue.poll()
            for (next in nodes[prev]){
                if (visit[next]) continue
                visit[next] = true
                parent[next] = prev
                queue.add(next)
            }
        }
    }
    bfs()
    for (index in 2..n){
        println(parent[index])
    }
}