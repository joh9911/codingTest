package fiftyfourth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    var triple = Triple(0,0,0)
    val rank = Array(n){Triple(0,0,0)}
    repeat(n){
        val (idx, g, s, b) = br.readLine().split(' ').map{it.toInt()}
        rank[idx - 1] = Triple(g,s,b)
        if (idx == k)
            triple = Triple(g,s,b)
    }
    rank.sortWith(compareBy<Triple<Int,Int,Int>>{it.first}
        .thenBy{it.second}
        .thenBy{it.third})
    rank.reverse()
    for (index in rank.indices){
        if (rank[index] == triple){
            println(index+1)
            break
        }
    }
}