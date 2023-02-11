package firstDay

import java.io.*

fun main() =with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine().toInt()
    var fn = n
    var count = 0
    while (true){
        val num1 = fn/10 + fn%10
        val num2 = fn%10*10 + num1%10
        fn = num2
        count++
        if (fn == n)
            break
    }
    println(count)
}
