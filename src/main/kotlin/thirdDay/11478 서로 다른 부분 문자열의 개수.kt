package thirdDay
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val set = mutableSetOf<String>()
    for (index in input.indices){
        for (index1 in 0 until input.length - index){
            set.add(input.substring(index1,index1 + index + 1))
        }
    }
    println(set.size)

}