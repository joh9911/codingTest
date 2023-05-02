package thirtySecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()
    val ans = (a*b*c).toString()
    val map = mutableMapOf<String,Int>()
    for (index in ans.indices){
        map[ans[index].toString()] = map.getOrDefault(ans[index].toString(),0) + 1
    }
    for (index in 0..9){
        println(map.getOrDefault(index.toString(),0))
    }
}