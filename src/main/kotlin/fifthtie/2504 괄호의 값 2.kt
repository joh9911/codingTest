import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val stack = LinkedList<Char>()
    var answer = 0
    var temp = 1
    for (i in input.indices) {
        when(input[i]) {
            '(' -> {
                stack.addLast('(')
                temp *= 2
            }
            '[' -> {
                stack.addLast('[')
                temp *= 3
            }
            ')' -> {
                if (stack.isEmpty() || stack[stack.size - 1] != '(') {
                    answer = 0
                    break
                }
                if (input[i - 1] == '(') {
                    answer += temp
                }
                temp /= 2
                stack.removeLast()
            }
            ']' -> {
                if (stack.isEmpty() || stack[stack.size - 1] != '[') {
                    answer = 0
                    break
                }
                if (input[i - 1] == '[') {
                    answer += temp
                }
                temp /= 3
                stack.removeLast()
            }
        }
    }

    if (!stack.isEmpty()) {
        answer = 0
    }
    println("$answer")

}