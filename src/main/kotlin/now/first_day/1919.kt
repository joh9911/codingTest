package now.first_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val first = br.readLine()
    val second = br.readLine()

    val a = IntArray(26)
    val b = IntArray(26)

    for (index in 0 until first.count()){
        a[first[index].code - 97] += 1
    }
    for (index in 0 until second.count()){
        b[second[index].code - 97] += 1

    }
    var count = 0
    for (index in a.indices){
        count += Math.abs(a[index] - b[index])
    }
    println(count)
}