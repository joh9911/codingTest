package tenth.ninethDay

import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val stack = LinkedList<Char>()
    while (true){
        val input = br.readLine()
        if (input.length == 1 && input.last() == '.'){
            break
        }
        for (index in input.indices){
            if (input[index] == '(' || input[index] == '[')
                stack.add(input[index])
            else if (input[index] == ')'){
                if (stack.isNotEmpty() && stack.last == '(')
                    stack.removeLast()
                else
                    stack.add(input[index])
            }
            else if (input[index] == ']'){
                if (stack.isNotEmpty() && stack.last == '[')
                    stack.removeLast()
                else
                    stack.add(input[index])
            }
        }
        if (stack.isEmpty())
            bw.write("yes\n")
        else
            bw.write("no\n")
        stack.clear()

    }
    bw.flush()
}