package tenth.thirdDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String,String>()
    repeat(n){
        val (name,string) = br.readLine().split(' ')
        map[name] = string
    }
    map.filterValues{it == "enter"}.keys.sorted().reversed().forEach{
        println(it)
    }

}