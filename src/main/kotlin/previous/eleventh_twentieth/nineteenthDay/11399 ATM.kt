package eleventh_twentieth.nineteenthDay

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}.sorted()
    val list1 = arrayListOf<Int>()
    var sum = 0
    for(index in list.indices){
        sum += list[index]
        list1.add(sum)
    }
    println(list1.sum())
}