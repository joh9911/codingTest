package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 1 -> 3 4 8 -> 2, 7 6,
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n + 1){ mutableListOf<Int>() }
    val visit = Array(n + 1){false}
    val numbers = Array(n + 1){ false }
    repeat(n - 1){
        val (a,b) = br.readLine().split(" ").map { it.toInt() }
        arr[a].add(b)
        arr[b].add(a)
    }
    val answer = Array(n + 1){0}

    fun bfs1(){
        val queue = LinkedList<Int>()
        queue.add(1)
        visit[1] = true
        answer[1] = 0

        while(queue.isNotEmpty()){
            val prev = queue.poll()
            for (next in arr[prev]){
                if (visit[next]) continue
                visit[next] = true
                queue.add(next)
                answer[next] = answer[prev] + 1
                numbers[prev] = true
            }
        }
    }
    bfs1()

    var count = 0
    for (index in 1 until numbers.size){
        if (!numbers[index]){
            count += answer[index]
        }
    }


    if (count % 2 != 0){
        println("Yes")
    }
    else{
        println("No")
    }


}