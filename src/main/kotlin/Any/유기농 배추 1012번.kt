package Any
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCase = br.readLine().toInt()
    repeat(testCase){
        val (m, n, k) = br.readLine().split(' ').map{it.toInt()}
        val arr = Array(n){Array(m){0} }
        repeat(k){
            val (x,y) = br.readLine().split(' ').map{it.toInt()}
            arr[y][x] = 1
        }
        val xList = arrayOf(1, -1, 0, 0)
        val yList = arrayOf(0, 0, 1, -1)
        val visit = Array(n){Array(m){false} }
        val queue = LinkedList<Pair<Int,Int>>()
        var countList = mutableListOf<Int>()
        fun bfs(){
            for (y in arr.indices){
                for (x in arr[y].indices){
                    if (!visit[y][x]){
                        if (arr[y][x] == 1){
                            queue.add(Pair(y,x))
                            visit[y][x] = true
                            while (queue.isNotEmpty()){
                                val value = queue.poll()
                                for (index in xList.indices){
                                    val xDot = xList[index] + value.second
                                    val yDot = yList[index] + value.first
                                    if (xDot > m-1 || xDot < 0)
                                        continue
                                    if (yDot > n-1 || yDot < 0)
                                        continue
                                    if (visit[yDot][xDot])
                                        continue
                                    if (arr[yDot][xDot] == 1){
                                        queue.add(Pair(yDot,xDot))
                                        visit[yDot][xDot] = true
                                    }
                                }
                            }
                            countList.add(-1)
                        }
                    }
                }
            }
        }
        bfs()
        println(countList.size)
    }

}