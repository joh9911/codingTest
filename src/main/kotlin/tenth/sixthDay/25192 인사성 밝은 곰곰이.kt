package tenth.sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String,Int>()
    var count = 0
    repeat(n){
        val string = br.readLine()
        if (string == "ENTER")
            map.clear()
        else{
            if (map[string] == null){
                count += 1
                map[string] = 1
            }
        }

    }
    println(count)
}