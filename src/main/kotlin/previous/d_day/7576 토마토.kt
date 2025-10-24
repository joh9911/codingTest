package d_day
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m,n) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){Array(m){0} }
    val visit = Array(n){Array(m){false} }
    val roastLoc = arrayListOf<Pair<Int,Int>>()
    repeat(n){
        val input = br.readLine().split(' ').map{it.toInt()}
        for (index in input.indices){
            if (input[index] == 1){
                roastLoc.add(Pair(it, index))
            }
            arr[it][index] = input[index]
        }
    }
    val xList = arrayOf(1, -1, 0, 0)
    val yList = arrayOf(0, 0, 1, -1)
    var count = 0

    fun bfs(){
        val queue = LinkedList<Pair<Int,Int>>()
        for (index in roastLoc.indices){
            val value = roastLoc[index]
            queue.add(value)
            visit[value.first][value.second] = true
        }

        while (queue.isNotEmpty()){
            for (i in 0 until queue.size){
                val first = queue.poll()
                for (index in 0 until 4){
                    val nY = first.first + yList[index]
                    val nX = first.second + xList[index]
                    if (nY !in 0 until n || nX !in 0 until m) continue
                    if (visit[nY][nX] || arr[nY][nX] == -1) continue
                    arr[nY][nX] = 1
                    visit[nY][nX] = true
                    queue.add(Pair(nY, nX))
                }
            }
            count += 1
        }
    }
    bfs()
    var tag = false
    for (i in arr.indices){
        for (j in arr[i].indices){
            if (arr[i][j] == 0){
                tag = true
            }
        }
    }
    if (tag)
        println(-1)
    else
        println(count - 1)


}