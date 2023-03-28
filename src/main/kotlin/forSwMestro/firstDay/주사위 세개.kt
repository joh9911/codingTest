package firstDay

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b,c) = br.readLine().split(' ').map { it.toInt() }
    calculator(a,b,c)
}
fun calculator(a: Int, b: Int, c: Int){
    var prize = 0
    if (a == b && a == c){
        prize = 10000 + a*1000
        println(prize)
    }
    else if (a != b && a != c && c != b){
        val list = arrayListOf(a, b, c)
        prize = list.max() * 100
        println(prize)
    }
    else{
        val list = arrayListOf(a, b, c)
        val distinctList = arrayListOf(a, b, c).distinct()

        for (index in distinctList.indices){
            if (list.contains(distinctList[index]))
                list.remove(distinctList[index])
        }
        prize = 1000 + (list[0]*100)
        println(prize)
    }

}

