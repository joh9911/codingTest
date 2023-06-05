package fiftyfirst_sixtieth.fiftysecond// 10 : 34
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val stack = LinkedList<Int>()
    for (index in n downTo 1){
        stack.add(index)
    }

    while(stack.size != 1){
        print("${stack.removeLast()} ")
        if (stack.size == 1)
            break
        val top = stack.removeLast()
        stack.addFirst(top)
    }
    print(stack.first())
}
// 10 : 38