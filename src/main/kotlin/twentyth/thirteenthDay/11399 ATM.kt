package twentyth.thirteenthDay

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}.sorted()
    var sum = 0
    for (index in list.indices){
        for (index1 in index downTo 0){
            sum += list[index1]
        }
    }
    println(sum)
}