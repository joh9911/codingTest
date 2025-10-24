package twentyFirst_thirtieth.`twenty nineth Day`
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val queue = Array(n){0}
    for (index in 0 until n){
        queue[index] = index+1
    }
    val extraList = LinkedList<Int>()
    repeat(m){
        val input = br.readLine().split(' ').map{it.toInt()}
        val begin = input[0] - 1
        val end = input[1] - 1
        val mid = input[2] - 1
        for (index in mid .. end){
            extraList.add(queue[index])
        }
        for (index in begin until mid){
            extraList.add(queue[index])
        }
        for (index in begin..end){
            queue[index] = extraList.removeFirst()
        }

    }
    queue.forEach{print("$it ")}
}