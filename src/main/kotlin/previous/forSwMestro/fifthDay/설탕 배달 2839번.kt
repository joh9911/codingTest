package fifthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var value = n
    var count = 0
    while (true){
        if (value%5 == 0){
            println(count + value/5)
            return
        }
        if (value == 0){
            println(value/3)
            return
        }
        if (value < 0){
            println(-1)
            return
        }
        value -= 3
        count ++
    }
}