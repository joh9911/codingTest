package ninethDay
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val queue = LinkedList<Int>()
    for (index in n downTo 1){
        queue.add(index)
    }
    while (queue.size != 1){
        queue.removeLast()
        val last = queue.removeLast()
        queue.addFirst(last)
    }
    println(queue.first)

}