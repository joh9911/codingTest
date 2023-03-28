package secondDay

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val mp = mutableMapOf(Pair(2,"ABC"),Pair(3,"DEF")
        ,Pair(4,"GHI"),Pair(5,"JKL"),Pair(6,"MNO"),Pair(7,"PQRS")
        ,Pair(8,"TUV"),Pair(9,"WXYZ"))
    val word = br.readLine()
    var time = 0
    for (index in word.indices){
        val key = mp.filterValues{it.contains(word[index])}.keys.toList()
        time += key[0]+1
    }
    println(time)
}