package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Pair<Int,Int>>()
    repeat(n){
        val (x,y) = br.readLine().split(' ').map{it.toInt()}
        list.add(Pair(x,y))
    }
    val mp = mutableMapOf<Int,Int>()
    list.forEach{
        if (mp.containsKey(it.first))
            mp[it.first] = mp[it.first]!! + 1
        else
            mp[it.first] = 1
    }
    list.sortBy{it.first}
    println(list.indexOf())
}