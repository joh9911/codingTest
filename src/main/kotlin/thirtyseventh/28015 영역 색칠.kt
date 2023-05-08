package thirtyseventh
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){Array(m){0} }
    val dp = Array(n){Array(m){0} }
    repeat(n){
        val list = br.readLine().split(' ').map{it.toInt()}
        for (index in list.indices){
            arr[it][index] = list[index]
        }
    }

    for (index in 0 until n){
        var first = -1
        if (arr[index][0] != 0){
            first = arr[index][0]
            dp[index][0] = 1
        }

        for (index1 in 1 until m){
            val cur = arr[index][index1]
            val prev = arr[index][index1 - 1]
            if (cur == 0){
                dp[index][index1] = dp[index][index1-1]
                first = -1
            }
            else{
                if (first == -1){
                    first = cur
                    dp[index][index1] = dp[index][index1-1] + 1
                }
                else{
                    if (cur == first)
                        dp[index][index1] = dp[index][index1-1]
                    else{
                        if (cur != prev)
                            dp[index][index1] = dp[index][index1-1] + 1
                        else
                            dp[index][index1] = dp[index][index1-1]
                    }

                }
            }
        }
    }
    var count = 0L
    for (index in 0 until n){
        count += dp[index][m-1]
    }
    println(count)

}