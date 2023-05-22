package fiftysecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = Array(101){Array(101){0} }
    repeat(4){
        val (x1, y1, x2, y2) = br.readLine().split(' ').map{it.toInt()}
        for (i in y1 until y2){
            for (j in x1 until x2){
                arr[i][j] = 1
            }
        }
    }
    var sum = 0
    for (i in arr.indices){
        for (j in arr[i].indices){
            sum += arr[i][j]
        }
    }
    println(sum)
}