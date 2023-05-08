package thirtyfourth
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>()
    repeat(n){
        val x = br.readLine().toInt()
        if (x == 0){
            if (pq.isNotEmpty())
                println(pq.poll())
            else
                println(0)
        }
        else{
            pq.add(x)
        }
    }
}