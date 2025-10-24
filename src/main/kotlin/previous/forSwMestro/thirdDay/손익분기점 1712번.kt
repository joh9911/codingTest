package thirdDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b,c) = br.readLine().split(' ').map{it.toInt()}
    var count = 1
    if (b >= c)
        println(-1)
    else
        count = (a/(c-b) + 1)
    println(count)

}

// int로 나눗셈 하는게 존나 안좋은 습관이다.