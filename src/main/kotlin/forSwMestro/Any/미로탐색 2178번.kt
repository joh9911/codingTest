package Any
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n+1){Array(m+1){0} }
    repeat(n){
        val string = br.readLine()
        for (index in string.indices){
            arr[it+1][index+1] = string[index].toString().toInt()
        }
    }
    val visit = Array(n+1){Array(m+1){false} }
    val xList = arrayOf(1, -1, 0, 0)
    val yList = arrayOf(0, 0, 1, -1)
    val queue = LinkedList<Pair<Int,Int>>()
    var count = 1
    fun bfs(y: Int, x: Int){
        queue.add(Pair(y,x))
        visit[y][x] = true
        queue.add(Pair(-1,-1))
        while (queue.isNotEmpty()){
            if (queue.first == Pair(-1,-1)){
                queue.add(Pair(-1,-1))
                count += 1
                queue.removeFirst()
            }

            val value = queue.poll()
            if (value.second == m && value.first == n)
                break
            for (index in xList.indices){
                val xDot = value.second + xList[index]
                val yDot = value.first + yList[index]
                if (xDot < 1 || xDot > m)
                    continue
                if (yDot < 1 || yDot > n)
                    continue
                if (visit[yDot][xDot])
                    continue
                if (arr[yDot][xDot] == 1){
                    queue.add(Pair(yDot,xDot))
                    visit[yDot][xDot] = true
                }
            }
        }
    }
    bfs(1,1)
    println(count)
}