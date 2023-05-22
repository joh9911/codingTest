package fiftysecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val input = br.readLine().split(' ').map{it.toInt()}

    var last = input.last()
    val t = arrayListOf<Int>()
    for (index in input.size - 2 downTo 0){
        if (last < input[index]){
            for (i in 0 until index){
                print()
            }
        }
        else{
            t.add(last)
            last = input[index]
        }
    }




}