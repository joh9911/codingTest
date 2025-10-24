package now.first_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val int = br.readLine().toInt()
    val list = mutableListOf<Pair<Int,String>>()
    for (index in 0 until int){
        val (a,b) = br.readLine().split(' ')
        list.add(Pair(a.toInt(),b))
    }
    list.sortBy { it.first }
    list.forEach{
        println("${it.first} ${it.second}")
    }
}