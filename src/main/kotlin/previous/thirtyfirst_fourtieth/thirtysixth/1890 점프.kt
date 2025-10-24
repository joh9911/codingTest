package thirtyfirst_fourtieth.thirtysixth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val location = Array(n){Array(n){0} }
    val visit = Array(n){Array(n){false} }
    repeat(n){
        val token = StringTokenizer(br.readLine())
        for (index in 0 until n){
            location[it][index] = token.nextToken().toInt()
        }
    }
    var curPosition = Pair(0,0) // first = y, second = x

    val queue = LinkedList<Pair<Int,Int>>()
    queue.add(curPosition)
    var count = 0L

    while(queue.isNotEmpty()){
        for (index in queue.indices){
            val first = queue.poll()
            if (!visit[first.first][first.second]){

                if (first.first == n-1 && first.second == n-1){
                    count ++
                    continue
                }
                else
                    visit[first.first][first.second] = true

                val locationValue = location[first.first][first.second]


                if (first.first + locationValue <= n-1){
                    queue.add(Pair(first.first+locationValue, first.second))
                }

                if (first.second + locationValue <= n-1){
                    queue.add(Pair(first.first, first.second + locationValue))
                }

            }
        }
    }
    println(count)
}