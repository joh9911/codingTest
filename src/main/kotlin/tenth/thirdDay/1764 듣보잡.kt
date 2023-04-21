package tenth.thirdDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val nMap = mutableMapOf<String,Int>()
    repeat(n){
        val input = br.readLine()
        nMap[input] = 1
    }
    repeat(m){
        val input = br.readLine()
        nMap[input] = nMap.getOrDefault(input, 0) + 1
    }
    val set = nMap.filterValues{it >= 2}.keys.sorted()
    println(set.size)
    set.forEach{
        println(it)
    }
}