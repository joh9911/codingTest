package thirtyThird
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
    val valueArr = Array(V+1){-1}
    val queue = LinkedList<Pair<Int,Int>>()
    arr[k].forEach{queue.add(it)}
    while(queue.isNotEmpty()){
        val first = queue.poll()
        if (valueArr[first.first] == -1)
            valueArr[first.first] = first.second
        else{
            valueArr[first.first] = Math.min(valueArr[first.first], first.second)
        }

        arr[first.first].forEach{queue.add(Pair(it.first, it.second + first.second))}
    }

    for (index in 1..V){
        if (index == k)
            println(0)
        else{
            if (valueArr[index] == -1)
                println("INF")
            else
                println(valueArr[index])
        }
    }


}