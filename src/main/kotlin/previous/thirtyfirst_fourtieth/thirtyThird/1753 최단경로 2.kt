package thirtyfirst_fourtieth.thirtyThird
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (V,E) = br.readLine().split(' ').map{it.toInt()}
    val k = br.readLine().toInt()
    val arr = Array(V+1){arrayListOf<Pair<Int,Int>>()}
    repeat(E){
        val (u,v,w) = br.readLine().split(' ').map{it.toInt()}
        arr[u].add(Pair(v,w))
    }
    val valueArr = Array(V+1){Int.MAX_VALUE}
    valueArr[k] = 0

    val queue = PriorityQueue<Pair<Int,Int>>(compareBy{it.second})
    queue.add(Pair(k,0))

    while(queue.isNotEmpty()){
        val (node, value) = queue.poll()
        if (valueArr[node] < value) continue

        for ((nextNode, nextValue) in arr[node]){
            val newValue = value + nextValue
            if (valueArr[nextNode] > newValue){
                valueArr[nextNode] = newValue
                queue.add(Pair(nextNode, newValue))
            }
        }
    }

    for (index in 1..V){
        if (index == k)
            println(0)
        else{
            if (valueArr[index] == Int.MAX_VALUE)
                println("INF")
            else
                println(valueArr[index])
        }
    }

}