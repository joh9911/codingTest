package thirtyseventh
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    var first = list.first()
    var count = 1
    for (index in 1 until n){
        if (first <= list[index])
            count += 1
        first = list[index]
    }
    println(count)
}