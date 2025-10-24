package kakao.oct_third

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, v) = br.readLine().split(' ').map { it.toInt() }
    val array = Array(n + 1){ mutableListOf<Int>() }
    repeat(m){
        val (a,b) = br.readLine().split(' ').map { it.toInt() }
        array[a].add(b)
        array[b].add(a)
    }
    array.forEach {
        it.sort()
    }

    val visit = Array(n+1){false}
    fun dfs(node: Int){
        print("$node ")
        visit[node] = true
        for (next in array[node])
            if (!visit[next]) dfs(next)
    }

    fun bfs(node: Int){
        val queue = LinkedList<Int>()
        queue.add(node)
        visit[node] = true
        while(queue.isNotEmpty()){
            val value = queue.poll()
            print("$value ")
            for (next in array[value])
                if (!visit[next]) {
                    visit[next] = true
                    queue.add(next)
                }
        }
    }

    dfs(v)
    visit.fill(false)
    println()
    bfs(v)

}