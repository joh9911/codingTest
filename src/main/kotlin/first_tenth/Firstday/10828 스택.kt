package first_tenth.Firstday
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val stack = LinkedList<Int>()

    fun stackFun(string: String){
        if (string.split(' ').size == 2) {
            val list = string.split(' ')
            stack.push(list[list.size - 1].toInt())
        }
        else if (string == "top"){
            if (stack.isEmpty())
                println(-1)
            else
                println(stack.first)
        }
        else if (string == "size"){
            println(stack.size)
        }
        else if (string == "pop"){
            if (stack.isEmpty())
                println(-1)
            else
                println(stack.poll())
        }
        else if (string == "empty"){
            if (stack.isEmpty())
                println(1)
            else
                println(0)
        }
    }
    repeat(n){
        stackFun(br.readLine())
    }
}