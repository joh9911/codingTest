package Any
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val xList = arrayOf(1, -1, 0, 0)
    val yList = arrayOf(0, 0, 1, -1)
    val n = br.readLine().toInt()
    val arr = Array(n){Array(n){0} }
    repeat(n){
        val string = br.readLine()
        for (index in string.indices){
            arr[it][index] = string[index].toString().toInt()
        }
    }
    val countList = mutableListOf<Int>()
    val queue = LinkedList<Pair<Int,Int>>()
    val visit = Array(n){Array(n){false} }
    var count = 0
    fun bfs(y: Int, x: Int){
        queue.add(Pair(y,x))
        visit[y][x] = true
        while (queue.isNotEmpty()){
            count += 1
            val value = queue.poll()
            for (index in xList.indices){
                val xDot = xList[index] + value.second
                val yDot = yList[index] + value.first
                if (xDot < 0 || xDot > n-1)
                    continue
                if (yDot < 0 || yDot > n-1)
                    continue
                if (visit[yDot][xDot])
                    continue
                if (arr[yDot][xDot] == 1){
                    visit[yDot][xDot] = true
                    queue.add(Pair(yDot,xDot))
                }
            }
        }
        countList.add(count)
        count = 0
    }
    for (y in arr.indices){
        for (x in arr[y].indices){
            if (!visit[y][x]){
                if (arr[y][x] == 1)
                    bfs(y,x)
            }
        }
    }
    println(countList)
}