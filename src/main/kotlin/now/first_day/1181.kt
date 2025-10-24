package now.first_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val pq = PriorityQueue(compareBy<String> { it.length }.thenBy { it })
    for (index in 0 until n){
        val input = br.readLine()
        if (pq.contains(input))
            continue
        pq.add(input)
    }

    while(pq.isNotEmpty()){
        println(pq.poll())
    }


}