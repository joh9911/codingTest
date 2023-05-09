package thirtynineth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){Array(n){0} }
    var max = 0

    repeat(n){
        val list = br.readLine().split(' ').map{it.toInt()}
        for (index in list.indices){
            max = Math.max(max, list[index])

            arr[it][index] = list[index]
        }
    }
    val xList = arrayListOf(0, -1, 1, 0)
    val yList = arrayListOf(-1, 0, 0, 1)



    fun bfs(y: Int, x: Int, target: Int, visit: Array<Array<Boolean>>){
        val queue = LinkedList<Pair<Int,Int>>()
        queue.add(Pair(y,x))
        visit[y][x] = true
        while(queue.isNotEmpty()){
            val curNode = queue.poll()

            for (index in xList.indices){
                val nX = curNode.second + xList[index]
                val nY = curNode.first + yList[index]

                if (nX !in 0 until n || nY !in 0 until n) continue
                if (arr[nY][nX] <= target || visit[nY][nX]) continue
                queue.add(Pair(nY,nX))
                visit[nY][nX] = true

            }

        }
    }


    var ans = 1
    for (index in 1 .. max){
        val visit = Array(n){Array(n){false} }
        var count = 0
        for (i in arr.indices){
            for (j in arr[i].indices){
                if (visit[i][j]) continue
                if (arr[i][j] <= index)continue
                bfs(i,j,index, visit)
                count++
            }
        }
        ans = Math.max(ans,count)
    }
    println(ans)

}