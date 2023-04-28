package `twenty eighth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    val dp = Array(n){0}
    val dp1 = Array(n){0}
    dp[0] = 1
    dp1[n-1] = 1
    for (i in 1 until list.size) {
        var max = 0
        for (j in 0 until i) {
            if (list[i] > list[j])
                max = Math.max(dp[j], max)
        }
        dp[i] = max + 1
    }
    for (i in list.size - 2 downTo 0){
        var max = 0
        for (j in list.size - 1 downTo i){
            if (list[i] > list[j])
                max = Math.max(dp1[j], max)
        }
        dp1[i] = max + 1
    }
    var max = 0
    for (index in dp.indices){
        max = Math.max(max, (dp[index] + dp1[index]))
    }
    println(max-1)

}