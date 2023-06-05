package fiftyfirst_sixtieth.fiftyeighth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val input = br.readLine().split(' ').map{it.toInt()}
    val dp = Array(n){0}
    val dp1 = Array(n){0}
    for (index in 1 until input.size){
        if (input[index - 1] <= input[index]){
            dp[index] = Math.max(dp[index], dp[index - 1] + 1)
        }
        if (input[index - 1] >= input[index]){
            dp1[index] = Math.max(dp1[index], dp1[index - 1] + 1)
        }
    }
    var max = 0
    for (index in dp.indices){
        max = Math.max(max, Math.max(dp[index], dp1[index]))
    }
    println(max + 1)
}