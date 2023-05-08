package thirtyThird
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b) = br.readLine().split(' ').map{it.toInt()}

    fun v(a: Int, b: Int): Int{
        var num = 1
        var max = 0
        while(true){
            if (num > Math.min(a,b))
                break

            if (a % num == 0 && b % num == 0){
                max = Math.max(max,num)
            }
            num++
        }
        return max
    }

    val e = v(a,b)
    println(e)
    println(a*b / e)
}