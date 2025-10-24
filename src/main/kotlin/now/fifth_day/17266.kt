package now.fifth_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val location = br.readLine().split(' ').map { it.toInt() }

    if (m != 1){
        val first = location.first()
        val last = n - location.last()
        var max = Math.max(first, last)
        for (index in 1 until location.size){
            val f = location[index]
            val b = location[index - 1]
            if ((f - b) % 2 == 0){
                max = Math.max(max, (f - b) / 2)
            }
            else{
                max = Math.max(max, ((f - b) / 2) + 1)
            }
        }
        println(max)
    }else{
        val first = location.first()
        val last = n - location.first()

        val max = Math.max(first, last)
        println(max)

    }

}