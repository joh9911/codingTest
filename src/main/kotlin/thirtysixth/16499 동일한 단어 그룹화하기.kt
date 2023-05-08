package thirtysixth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String,Int>()
    repeat(n){
        val pq = PriorityQueue<Char>(compareBy{it.code})
        val input = br.readLine()
        for (index in input.indices){
            pq.add(input[index])
        }
        var string = ""
        while(pq.isNotEmpty()){
            string+=pq.poll()
        }
        map[string] = map.getOrDefault(string,0) + 1
    }
    println(map.filter{it.value >= 1}.count())
}