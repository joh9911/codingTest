package thirtyfirst_fourtieth.thirtysixth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    var count = 0

    for (index in 0 until n-1){
        val one = list[index]
        for (index1 in index + 1 until n){
            val two = list[index1]
            if (one+two == m)
                count++
        }
    }
    println(count)

}