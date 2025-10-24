package first_tenth.SecondDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = br.readLine().split(' ').map{it.toDouble()}
    val a = list[0]
    val b = list[1]
    val c = list[2]
    val d = list[3]
    val e = list[4]
    val f = list[5]
    var x = 0
    var y = 0
    for (index in -999..999){
        for (index1 in -999..999){
            if (a*index + b*index1 == c && d*index + e*index1 == f){
                x = index
                y = index1
            }
        }
    }
    println("$x $y")
}