package thirtyfirst_fourtieth.fourtieth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val heap = PriorityQueue<Int>(compareBy<Int>{Math.abs(it)}.thenBy{
        it
    })
    repeat(n){
        val x = br.readLine().toInt()
        if (x != 0)
            heap.add(x)
        else{
            if (heap.isEmpty())
                println(0)
            else{
                println(heap.poll())
            }
        }
    }


}