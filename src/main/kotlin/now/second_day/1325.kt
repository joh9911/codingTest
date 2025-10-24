package now.second_day

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n, m) = br.readLine().split(" ").map{it.toInt()}
    val arr = Array(n + 1){ mutableListOf<Int>() }
    repeat(m){
        val (a,b) = br.readLine().split(" ").map{it.toInt()}
        arr[b].add(a)
    }

    val visit = Array(n + 1){false}
    val ans = IntArray(n + 1)
    var max = 0

    fun bfs(start: Int): Int{
        val queue = LinkedList<Int>()
        queue.add(start)
        Arrays.fill(visit, false)
        visit[start] = true
        var value = 1

        while (queue.isNotEmpty()){
            val prev = queue.poll()
            for (next in arr[prev]){
                if (visit[next]) continue
                visit[next] = true
                value ++
                queue.add(next)
            }
        }
        return value
    }



    for (index in 1..n){
        ans[index] = bfs(index)
        max = Math.max(ans[index], max)
    }


    for (index in 1..n){
        if (ans[index] == max)
            bw.write("$index ")
    }

    bw.flush()
    bw.close()
}