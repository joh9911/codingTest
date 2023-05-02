package eleventh_twentyth.thirteenthDay

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b,v) = br.readLine().split(' ').map{it.toInt()}
    val n = v - a
    var count = 0
    count += n / (a-b)
    if (n%(a-b) != 0)
        count += 1
    println(count + 1)

}