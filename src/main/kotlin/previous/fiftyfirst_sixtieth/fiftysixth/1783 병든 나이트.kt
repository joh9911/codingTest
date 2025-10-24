package fiftyfirst_sixtieth.fiftysixth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n,m) = br.readLine().split(' ').map{it.toInt()}

    var count = 0
    when(n){
        1 -> count = 1
        2 -> count = Math.min(4,(m+1) / 2)
        else -> {
            if (m <= 6) count = Math.min (4,m)
            else count =m - 2
        }
    }
    println(count)

}