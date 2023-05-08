package thirtyfourth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = Array(n+1){0.toBigInteger()}
    if (n == 0)
        println(0)
    else{
        dp[1] = 1.toBigInteger()
        for (index in 2..n){
            dp[index] = index.toBigInteger()*dp[index-1]
        }
        val str = dp[n].toString()
        var count = 0
        for (index in str.length-1 downTo 1){
            if (str[index] != '0')
                break
            count++
        }
        println(count)
    }

}