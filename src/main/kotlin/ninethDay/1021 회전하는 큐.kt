package ninethDay
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var twoCount = 0
    var threeCount = 0
    val queue = LinkedList<Int>()
    val (n,m) = br.readLine().split(' ').map { it.toInt() }
    repeat(n){
        queue.add(it + 1)
    }
    val list = br.readLine().split(' ').map { it.toInt() }
    list.forEach{
        if (queue.size % 2 == 0){
            if (queue.indexOf(it) >= queue.size / 2){
                while(queue.first != it){
                    queue.addFirst(queue.removeLast())
                    threeCount ++
                }
            }
            else{
                while(queue.first != it){
                    queue.addLast(queue.removeFirst())
                    twoCount++
                }
            }
            queue.removeFirst()
        }
        else{
            if (queue.indexOf(it) > queue.size / 2){
                while(queue.first != it){
                    queue.addFirst(queue.removeLast())
                    threeCount ++
                }
            }
            else{
                while(queue.first != it){
                    queue.addLast(queue.removeFirst())
                    twoCount++
                }
            }
            queue.removeFirst()
        }
    }
    println(twoCount + threeCount)

}
// 오 한번에 푼거 첨이야!