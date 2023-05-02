package first_tenth.ninethDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val deque = LinkedList<Int>()
    val n = br.readLine().toInt()
    repeat(n){
        val input = br.readLine()
        if (input.split(' ').size == 2){
            if (input.split(' ').first().split('_').last() == "front"){
                deque.addFirst(input.split(' ').last().toInt())
            }
            else
                deque.addLast(input.split(' ').last().toInt())
        }
        else if (input.split('_').size == 2){
            if (input.split('_').last() == "back"){
                if (deque.isEmpty())
                    bw.write("-1\n")
                else
                    bw.write("${deque.removeLast()}\n")
            }
            else{
                if (deque.isEmpty())
                    bw.write("-1\n")
                else
                    bw.write("${deque.removeFirst()}\n")
            }
        }
        else if (input == "size")
            bw.write("${deque.size}\n")
        else if (input == "empty"){
            if (deque.isEmpty())
                bw.write("1\n")
            else
                bw.write("0\n")
        }
        else if (input == "front"){
            if (deque.isEmpty())
                bw.write("-1\n")
            else
                bw.write("${deque.first}\n")
        }
        else{
            if (deque.isEmpty())
                bw.write("-1\n")
            else
                bw.write("${deque.last}\n")
        }
    }
    bw.flush()
}