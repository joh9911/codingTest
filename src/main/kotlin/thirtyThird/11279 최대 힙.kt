package thirtyThird
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val heap = PriorityQueue<Int>(Collections.reverseOrder())
    repeat(n){
        val x = br.readLine().toInt()
        if (x == 0){
            if (heap.isEmpty())
                println(0)
            else
                println(heap.poll())
        }
        else{
                heap.add(x)
            }
        }
    }
