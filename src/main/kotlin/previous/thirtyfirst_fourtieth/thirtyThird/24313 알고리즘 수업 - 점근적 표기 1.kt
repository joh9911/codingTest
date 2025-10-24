package thirtyfirst_fourtieth.thirtyThird
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a1, a0) = br.readLine().split(' ').map{it.toInt()}
    val c = br.readLine().toInt()
    val n0 = br.readLine().toInt()
    var tag = true
    for (index in n0..100){
        if ((a1*index + a0) > c*index){
            tag = false
            break
        }
    }
    if (tag)
        println(1)
    else
        println(0)


}