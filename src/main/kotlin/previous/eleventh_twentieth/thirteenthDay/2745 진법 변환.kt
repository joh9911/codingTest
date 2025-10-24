package eleventh_twentieth.thirteenthDay

import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val map = mutableMapOf<Char,Int>()
    var i = 10
    for (index in 'A'..'Z'){
        map[index] = i
        i++
    }
    val (n,b) = br.readLine().split(' ')
    val ans = Integer.valueOf(n,b.toInt()).toLong()
    println(ans)

}