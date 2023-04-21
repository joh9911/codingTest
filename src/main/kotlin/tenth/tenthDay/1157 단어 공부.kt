package tenth.tenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()
    val map = mutableMapOf<Char,Int>()
    string.forEach{
        if (it.code >= 97){
            val big = (it.code - 32).toChar()
            map[big] = map.getOrDefault(big,0) + 1
        }
        else
            map[it] = map.getOrDefault(it,0) + 1
    }

    val maxCount = map.maxBy{it.value}.value
    val list = map.filterValues{it == maxCount}
    if (list.size == 1)
        println(list.keys.first())
    else
        println("?")
}