package twentyFirst_thirtyth.`twenty second Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp =  Array(n+1){0}
    if (n <= 3)
        if (n==1)
            println(0)
        else
            println(1)
    else{
        dp[1] = 1
        dp[2] = 1
        dp[3] = 1
        for (index in 4 .. n){
            if (index % 3 == 0 && index % 2 == 0)
                dp[index] = Math.min(Math.min(dp[index/3], dp[index/2]),dp[index-1]) + 1
            else if (index % 3 == 0)
                dp[index] = Math.min(dp[index/3], dp[index-1]) + 1
            else if (index % 2 == 0)
                dp[index] = Math.min(dp[index/2], dp[index-1]) + 1
            else
                dp[index] = dp[index-1] + 1
        }
        println(dp[n])
    }
}