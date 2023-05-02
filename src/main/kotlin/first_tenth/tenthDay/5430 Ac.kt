package first_tenth.tenthDay
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    var isError = false
    repeat(t){
        val queue = LinkedList<String>()
        val function = br.readLine()
        val n = br.readLine().toInt()
        if (n == 0){
            val list = br.readLine()
        }
        else{
            val list = br.readLine().split('[', ']')[1].split(',')
            list.forEach{
                queue.add(it)}
        }
        var rCount = 0
        function.forEach{
            if (it == 'R')
                rCount ++

            else{
                if (queue.isEmpty()){
                    isError = true
                }

                else{
                    if (rCount % 2 == 0){
                        queue.removeFirst()
                        rCount = 0
                    }
                    else
                        queue.removeLast()
                }
            }
        }

        if (isError)
            println("error")

        else {
            if (rCount % 2 == 0){
                println(queue.joinToString(",","[","]"))
            }
            else{
                queue.reverse()
                println(queue.joinToString(",","[","]"))
            }
        }

        isError = false
        rCount = 0
    }
}
