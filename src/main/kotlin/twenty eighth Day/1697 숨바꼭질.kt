package `twenty eighth Day`
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n,k) = br.readLine().split(' ').map{it.toInt()}
    val queue = LinkedList<Pair<Int,Int>>()
    val visit = Array(200000){false}
    var value = 0

    fun bfs(n: Int){
        queue.add(Pair(n,0))
        while(queue.isNotEmpty()){
            val first = queue.removeFirst()
            queue.add(Pair(first.first - 1,first.second + 1))
            queue.add(Pair(first.first + 1,first.second + 1))
            queue.add(Pair(first.first * 2,first.second + 1))
            println(queue)
            if (first.first == k){
                value = first.second
            }
            if (first.first < 0)
                continue
            if (!visit[first.first]){
                visit[first.first] = true
            }
            else
                continue

        }
    }
    bfs(n)
    println(value)
}
// 6 6
// 11