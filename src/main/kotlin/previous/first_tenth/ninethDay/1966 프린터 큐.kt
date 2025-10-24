package first_tenth.ninethDay
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val queue = LinkedList<Int>()
    val indexQueue = LinkedList<Int>()
    repeat(t){
        queue.clear()
        indexQueue.clear()
        val (n,m) = br.readLine().split(' ').map{it.toInt()}
        val important = br.readLine().split(' ').map{it.toInt()}

        for (index in important.indices){
            queue.add(important[index])
            indexQueue.add(index)
        }
        var max = queue.max()
        var count = 0
        while(true){
            if (queue.first < max){
                queue.addLast(queue.removeFirst())
                indexQueue.addLast(indexQueue.removeFirst())
            }
            else{
                count ++
                queue.removeFirst()
                if (queue.isEmpty()){
                    println(count)
                    break
                }
                else{
                    max = queue.max()
                    val index = indexQueue.removeFirst()
                    if (index == m){
                        println(count)
                        break
                    }
                }
            }
        }
    }
}
//첨에는 Pair로 했음 index를 알기 위해서
// 근데 그러면 max()를 모름