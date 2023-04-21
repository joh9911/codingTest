package tenth.eighthDay
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val k = br.readLine().toInt()
    val stack = LinkedList<Int>()
    repeat(k){
        val num = br.readLine().toInt()
        if (num == 0)
            stack.removeLast()
        else
            stack.add(num)
    }
    println(stack.sum())
}