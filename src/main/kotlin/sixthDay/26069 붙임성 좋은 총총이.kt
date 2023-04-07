package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String,Int>()
    repeat(n){
        val (a,b) = br.readLine().split(' ')
        if (a == "ChongChong")
            map[b] = 1
        else if (b == "ChongChong")
            map[a] = 1
        else{
            if (map[a] == 1)
                map[b] = 1
            if (map[b] == 1)
                map[a] = 1
        }
    }
    println(map.filter{it.value == 1}.count() + 1)
}