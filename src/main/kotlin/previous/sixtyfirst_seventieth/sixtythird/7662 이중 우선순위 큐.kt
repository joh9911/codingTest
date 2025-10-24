package sixtyfirst_seventieth.sixtythird
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val t = br.readLine().toInt()
    repeat(t){
        var pq = PriorityQueue<Int>()
        val k = br.readLine().toInt()
        var deleteCount = 0
        for (index in 0 until k){
            val input = br.readLine().split(' ')
            if (input.first() == "I"){
                pq.offer(input.last().toInt())
            }
            else{
                if (pq.isNotEmpty()){
                    if (input.last() == "1"){
                        if (deleteCount < pq.size) {
                            deleteCount += 1
                        }
                    }
                    else
                        pq.poll()
                }
            }
        }
        val realSize = pq.size - deleteCount
        if (realSize <= 0)
            bw.write("EMPTY\n")
        else{
            var max = Int.MIN_VALUE
            var min = Int.MAX_VALUE
            for (i in 0 until realSize + 1) {
                val value = pq.poll()
                max = Math.max(max,value)
                min = Math.min(min,value)
            }
            bw.write("$max $min\n")
        }
    }
    bw.flush()
}
//deleteCount == 2

// 1 10
// 5 7 8
