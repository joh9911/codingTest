package eighteenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var ans = 0
    var num = 666
    while (n != ans){
        if (num.toString().contains("666"))
            ans += 1
        num += 1
    }
    println(num - 1)
}