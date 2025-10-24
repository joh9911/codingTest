package now.first_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    var string = ""
    for (index in input.indices){
        if (input[index].isLowerCase())
            string += input[index].uppercase()
        else
            string += input[index].lowercase()
    }

    println(string)
}