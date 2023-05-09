package thirtynineth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val input = br.readLine().split(' ').map{it.toInt()}
    val (b,c) = br.readLine().split(' ').map{it.toInt()}
    var count = 0L
    for (index in input.indices){
        if (b >= input[index])
            count++
        else{
            val num = input[index] - b
            var cnt = num / c
            if (num % c != 0)
                cnt += 1
            count += cnt + 1
        }
    }
    println(count)


}