package first_tenth.ninethDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val stack = LinkedList<Char>()
    val t = br.readLine().toInt()

    repeat(t){
        val input = br.readLine()
        for (index in input.indices){
            if (stack.isNotEmpty() && stack.last != input[index]){
                if (stack.last != ')')
                    stack.removeLast()
            }
            else
                stack.add(input[index])
        }
        if (stack.isEmpty())
            bw.write("YES")
        else
            bw.write("NO")
        stack.clear()
        bw.write("\n")
        bw.flush()
    }
}
// 표준 출력을 이용하랬는데, println()을 써서 틀렸음