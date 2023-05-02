package twentyFirst_thirtyth.`twenty nineth Day`
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val stack = LinkedList<Char>()
    repeat(t){
        val string = br.readLine()
        for (index in string.indices){
            if (stack.isEmpty())
                stack.add(string[index])
            else{
                if (string[index] == '('){
                    if (stack.last() == string[index])
                        stack.add(string[index])
                    else
                        break
                }
                else if (string[index] == ')'){
                    if (stack.last() == string[index])
                        break
                    else
                        stack.removeLast()
                }
            }

        }
        if (stack.isEmpty())
            println("YES")
        else
            println("NO")
        stack.clear()
    }
}