package twentyFirst_thirtieth.`twenty nineth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t){
        val n = br.readLine().toInt()
        val dp = Array(n+1){Pair(0,0)}
        if (n ==0)
            println("1 0")
        else if (n==1)
            println("0 1")
        else {
            dp[0] = Pair(1,0)
            dp[1] = Pair(0,1)
            for (index in 2..n){
                dp[index] = Pair(dp[index-1].first+dp[index-2].first,dp[index-1].second+dp[index-2].second)
            }
            println("${dp[n].first} ${dp[n].second}")
        }
    }
}