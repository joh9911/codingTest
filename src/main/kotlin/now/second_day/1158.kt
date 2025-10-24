package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val queue = ArrayDeque<Int>()
    for (index in 1..n){
        queue.addLast(index)
    }
    val ans = mutableListOf<Int>()
    var count = 0
    while(queue.isNotEmpty()){
        val first = queue.first()
        queue.removeFirst()
        count ++
        if (count == m){
            ans.add(first)
            count = 0
        }else{
            queue.addLast(first)
        }

    }
    print("<")
    for (index in ans.indices){
        if (index == ans.size - 1){
            print("${ans[index]}>")
        }else{
            print("${ans[index]}, ")

        }
    }
}