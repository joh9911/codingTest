package twentyFirst_thirtieth.`twenty second Day`
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val stack = LinkedList<Int>()
    for (index in 1..n){
        stack.addLast(index)
    }
    while(stack.size != 1){
        stack.removeFirst()
        stack.addLast(stack.removeFirst())
    }
    println(stack.first())
}