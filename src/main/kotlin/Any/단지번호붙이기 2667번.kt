package Any
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val edges = Array(n){Array(n){0} }
    val visit = Array(n){Array(n){false} }
    repeat(n){
        val string = br.readLine()
        for (index in string.indices){
            edges[it][index] = string[index].toString().toInt()
        }
    }
    val queue = LinkedList<Pair<Int,Int>>()
    var countList = mutableListOf<Int>()
    var count = 0
    val xList = arrayOf(1, -1, 0, 0)
    val yList = arrayOf(0, 0, 1, -1)
    fun bfs(){
        for (y in edges.indices){
            for (x in edges.indices){
                if (!visit[y][x]){
                    if (edges[y][x] == 1){
                        queue.add(Pair(y,x))
                        visit[y][x] = true
                        while (queue.isNotEmpty()){
                            count += 1
                            val value = queue.poll()
                            for (index in xList.indices){
                                val xDot = xList[index] + value.second
                                val yDot = yList[index] + value.first
                                if (xDot > n-1 || xDot < 0)
                                    continue
                                if (yDot > n-1 || yDot < 0)
                                    continue
                                if (visit[yDot][xDot])
                                    continue
                                if (edges[yDot][xDot] == 1){
                                    queue.add(Pair(yDot,xDot))
                                    visit[yDot][xDot] = true
                                }

                            }
                        }
                        countList.add(count)
                        count = 0
                    }
                }
            }
        }
    }
    bfs()
    println(countList.size)
    countList.sorted().forEach{println(it)}
}