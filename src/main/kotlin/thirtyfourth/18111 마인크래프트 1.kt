package thirtyfourth
import java.io.*
import java.util.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m,b) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n*m){0}
    val dp = Array(n*m){0}
    var start = 0
    repeat(n){
        val token = StringTokenizer(br.readLine())
        for (index in start until m+start){
            arr[index] = token.nextToken().toInt()
        }
        start += m
    }
    var have = b
    var time = 0
    dp[0] = arr[0]
    for (index in 1 until dp.size){
        val a = arr[index]
        val c = dp[index - 1]
        if (a > c){
            val diff = a - c
            val put = diff*index
            val remove = diff*2
            if (have - put < 0){
                time += remove
                have += diff
                dp[index] = dp[index - 1]
            }
            else{
                if (put <= remove){
                    time += put
                    have -= put
                    dp[index] = arr[index]
                }
                else{
                    time += remove
                    have += diff
                    dp[index] = dp[index - 1]
                }
            }
        }
        else if (a < c){
            val diff = c - a
            val put = diff
            val remove = diff*index*2
            if (have - put < 0){
                time += remove
                have += diff
                dp[index] = arr[index]
            }
            else{
                if (put <= remove){
                    time += put
                    have -= put
                    dp[index] = dp[index-1]
                }
                else{
                    time += remove
                    have += diff
                    dp[index] = arr[index]
                }
            }
        }
        else
            dp[index] = dp[index-1]
    }
    print("$time ")
    print(dp[n*m-1])
}
