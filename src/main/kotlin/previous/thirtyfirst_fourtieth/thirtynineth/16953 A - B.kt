package thirtyfirst_fourtieth.thirtynineth
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b) = br.readLine().split(' ').map{it.toInt()}
    val dp = Array(1000000000){-1}
    dp[a] = 1
    fun check(num: Int): Int {
        var number = num
        while(number > 10){
            number %= 10
        }
        return number
    }
    for (index in a+1 .. b){
        val num = check(index)
        if (num == 1){
            val v = (index - 1) / 10
            if (dp[v] != -1){
                dp[index] = dp[v] + 1
            }
        }
        else{
            if (dp[index/2] != -1)
                dp[index] = dp[index/2] + 1
        }
    }

    println(dp[b])

}