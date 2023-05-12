package fourtyfirst
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val xList = arrayListOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val yList = arrayListOf(-1, -2, -2, -1, 1, 2, 2, 1)
    fun bfs(l: Int, curY: Int, curX: Int, moveY: Int, moveX: Int){
        val visit = Array(l){Array(l){false} }
        val queue = LinkedList<Pair<Int,Int>>()
        queue.add(Pair(curY,curX))
        visit[curY][curX] = true
        // 4 0
        // 6 1
        // 8 2
        // 7 0
        var count = 0
        var tag = false
        while(queue.isNotEmpty()){
            for (index in queue.indices){
                val first = queue.poll()
                if (first.first == moveY && first.second == moveX){
                    tag = true
                    break
                }
                for (index in xList.indices){
                    val mX = first.second + xList[index]
                    val mY = first.first + yList[index]

                    if (mX < 0 || mX > l - 1) continue
                    if (mY < 0 || mY > l - 1) continue
                    if (visit[mY][mX]) continue

                    queue.add(Pair(mY,mX))
                    visit[mY][mX] = true
                }
            }

            count += 1
            if (tag)
                break
        }
        println(count - 1)
    }
    repeat(t){
        val l = br.readLine().toInt()
        val (curY, curX) = br.readLine().split(' ').map{it.toInt()}
        val (moveY, moveX) = br.readLine().split(' ').map{it.toInt()}
        bfs(l, curY, curX, moveY, moveX)
    }

}
