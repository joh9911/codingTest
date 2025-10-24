package first_tenth.ninethDay
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val ans = arrayListOf<Int>()
    val queue = LinkedList<Int>()
    repeat(n){
        queue.add(it+1)
    }
    var count = 0
    while(queue.isNotEmpty()){
        count ++
        if (count % k == 0){
            ans.add(queue.removeFirst())
        }

        else{
            val first = queue.removeFirst()
            queue.addLast(first)
        }
    }
    print("<")
    for (index in ans.indices){
        if (index == ans.size - 1)
            print("${ans[index]}>")
        else
            print("${ans[index]}, ")
    }

}