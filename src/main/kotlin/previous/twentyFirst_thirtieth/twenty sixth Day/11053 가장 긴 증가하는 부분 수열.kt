package twentyFirst_thirtieth.`twenty sixth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    val dp = Array(n){0}
    dp[0] = 1
    for (i in 1 until list.size){
        if (list[i] > list[i-1]){
            var max = 0
            for (j in 0 until i){
                if (list[j] < list[i])
                    max = Math.max(dp[j],max)
            }
            dp[i] = max + 1
        }
        else if (list[i] < list[i - 1]){
            var min = 0
            for (j in 0 until i){
                if (list[j] < list[i])
                    min = Math.max(dp[j],min)
            }
            dp[i] = min + 1
        }

    }
    println(dp.max())
}