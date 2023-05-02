package twentyFirst_thirtyth.`twenty nineth Day`
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val queue = LinkedList<Int>()
    repeat(n){
        val input = br.readLine()
        if (input.contains("push")){
            val x = input.split(' ').last().toInt()
            queue.add(x)
        }
        else if (input == "pop"){
            if (queue.isEmpty())
                println(-1)
            else
                println(queue.removeFirst())
        }
        else if (input == "size"){
            println(queue.size)
        }
        else if(input == "empty"){
            if (queue.isEmpty())
                println(1)
            else
                println(0)
        }
        else if (input == "front"){
            if (queue.isEmpty())
                println(-1)
            else
                println(queue.first)
        }
        else{
            if (queue.isEmpty())
                println(-1)
            else
                println(queue.last)
        }

    }
}