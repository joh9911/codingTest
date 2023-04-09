package ninethDay
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val queue = LinkedList<Int>()
    val n = br.readLine().toInt()
    repeat(n){
        val input = br.readLine()
        if (input.startsWith("push"))
            queue.add(input.split(' ').last().toInt())
        else if (input == "pop"){
            if (queue.isEmpty())
                bw.write("-1\n")
            else{
                bw.write("${queue.removeFirst()}\n")
            }
        }
        else if (input == "size"){
            bw.write("${queue.size}\n")
        }

        else if (input == "empty"){
            if (queue.isEmpty())
                bw.write("1\n")
            else
                bw.write("0\n")
        }
        else if (input == "front"){
            if (queue.isEmpty())
                bw.write("-1\n")
            else
                bw.write("${queue.first}\n")
        }
        else if (input == "back"){
            if (queue.isEmpty())
                bw.write("-1\n")
            else
                bw.write("${queue.last}\n")
        }
    }
    bw.flush()
}