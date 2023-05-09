package thirtynineth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b) = br.readLine().split(' ').map{it.toLong()}

    val queue = LinkedList<Long>()
    var count = 0
    queue.add(a)
    var tag = false
    while(queue.isNotEmpty()){
        for (index in queue.indices){
            val first = queue.poll()

            if (first > b)
                continue

            if (first == b){
                println(count+1)
                tag = true
                break
            }

            if (first * 2 <= 1000000000)
                queue.add(first*2)

            if (first*10+1 <= 1000000000)
                queue.add(first*10+1)

        }
        if (tag)
            break
        count++
    }
    if (!tag)
        println(-1)

}