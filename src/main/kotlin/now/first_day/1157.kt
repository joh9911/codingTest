package now.first_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val lower = input.lowercase()
    val arr = IntArray(26)
    for (index in lower.indices){
        arr[lower[index].code - 97] ++
    }

    val max = arr.max()

    if (arr.count{it == max} >= 2){
        println("?")
    }
    else{
        println((arr.indexOf(max) + 97).toChar().uppercase())
    }

}