package thirteenthDay

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = arrayListOf<Pair<Int,Int>>()
    repeat(n){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        list.add(Pair(a,b))
    }
    val list2 = list.sortedWith(compareBy<Pair<Int,Int>>{it.second}.thenBy{it.first})

    var count = 0
    var temp = list2[0]

    for (index in list2.indices){
        if (index == 0){
            temp = list2[index]
            count ++
            continue
        }
        if (temp.second <= list2[index].first){
            count ++
            temp = list2[index]
        }
    }
    println(count)
}