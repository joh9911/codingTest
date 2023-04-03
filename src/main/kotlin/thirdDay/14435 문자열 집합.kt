package thirdDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(' ').map{it.toInt()}
    val s = mutableMapOf<String,Int>()
    repeat(n){
        s[br.readLine()] = 1
    }
    var count = 0
    repeat(m){
        if (s[br.readLine()] == 1)
            count += 1
    }
    println(count)
}