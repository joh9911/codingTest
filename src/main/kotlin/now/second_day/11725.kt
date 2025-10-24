package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n + 1){ mutableListOf<Int>() }

    repeat(n - 1){
        val (c, d) = br.readLine().split(" ").map{it.toInt()}
        arr[c].add(d)
        arr[d].add(c)
    }
    val visit = Array(n + 1){false}
    val result = Array(n + 1){0}

    fun bfs(){
        val queue = LinkedList<Int>()
        queue.add(1)
        visit[1] = true
        while(queue.isNotEmpty()){
            val prev = queue.poll()
            for (index in arr[prev].indices){
                if (visit[arr[prev][index]]) continue

                visit[arr[prev][index]] = true
                result[arr[prev][index]] = prev
                queue.add(arr[prev][index])
            }
        }
    }
    bfs()
    for (index in 2..n){
        println(result[index])
    }

}