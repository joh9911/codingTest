package eleventh_twentieth.twentiethDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){0}
    val dp = Array(n){0}
    var sum = 0
    dp[0] = list[0]
    var max = list[0]
    for (index in 1 until n){
        dp[index] = Math.max(dp[index - 1] + list[index], list[index])
        max = Math.max(max, dp[index])
    }
    println(max)

}