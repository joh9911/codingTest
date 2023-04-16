package fifteenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var w = 3
    var ans = 1
    for (index in 1..n){
        ans = w*w
        w += (w - 1)
    }
    println(ans)
} // 3 5 9