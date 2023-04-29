package `twenty eighth Day`
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n,k) = br.readLine().split(' ').map{it.toInt()}
    val queue = LinkedList<Pair<Int,Int>>()
    val visit = Array(200000){false}
    var value = -1

    fun bfs(n: Int){
        queue.add(Pair(n,0))
        while(queue.isNotEmpty()){
            for (index in queue.indices){
                val first = queue.removeFirst()

                if (first.first == k){
                    value = first.second
                    break
                }
                if (first.first - 1 >= 0 && !visit[first.first - 1]){
                    queue.add(Pair((first.first - 1),first.second + 1))
                    visit[first.first - 1] = true
                }
                if (first.first + 1 <= 100000 && !visit[first.first + 1]){
                    queue.add(Pair(first.first+1 ,first.second + 1))
                    visit[first.first+1] = true
                }
                if (first.first * 2 <= 100000 && !visit[first.first*2]){
                    queue.add(Pair(first.first * 2,first.second + 1))
                    visit[first.first*2] = true
                }
            }
            if (value != -1)
                break
        }
    }
    bfs(n)
    println(value)
}
// 6 6
// 11