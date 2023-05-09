package thirtynineth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val mp = Array(n+1){Pair(0,0)}
    repeat(n){
        val (t,p) = br.readLine().split(' ').map{it.toInt()}
        mp[it+1] = Pair(t,p)
    }
    val dp = Array(n+1){0}
    for (index in n downTo 1){
        val time = mp[index].first + index
        if (time - 1 <= n){
            if (time <= n){
                var max = 0
                for (j in time .. n){
                    if (j + mp[j].first - 1 <= n)
                        max = Math.max(dp[j],max)
                }
                dp[index] = mp[index].second + max
            }
            else{
                dp[index] = mp[index].second
            }

        }
    }
    println(dp.max())
}