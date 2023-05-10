package thirtyfirst_fourtieth.thirtysixth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = Array(n){Pair(0,0)}
    repeat(n){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        list[it] = Pair(a,b)
    }
    val rank = Array(n){0}
    for (index in list.indices){
        var count = 1
        val p = list[index]
        for (index1 in list.indices){
            if (index == index1)
                continue
            val c = list[index1]
            if (p.first < c.first && p.second < c.second){
                count += 1
            }
        }
        rank[index] = count
    }
    rank.forEach{print("$it ")}
}