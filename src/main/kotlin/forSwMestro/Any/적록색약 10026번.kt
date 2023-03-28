package Any
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){Array(n){""} }
    repeat(n){
        val string = br.readLine()
        for (index in string.indices){
            arr[it][index] = string[index].toString()
        }
    }

    val xList = arrayOf(1, -1, 0, 0)
    val yList = arrayOf(0, 0, 1, -1)
    val visit1 = Array(n){Array(n){false} }
    val visit2 = Array(n){Array(n){false} }
    val queue1 = LinkedList<Pair<Int,Int>>()
    val queue2 = LinkedList<Pair<Int,Int>>()
    var count1 = 0
    var count2 = 0
    fun bfs1(y: Int, x: Int){
        queue1.add(Pair(y,x))
        visit1[y][x] = true
        while(queue1.isNotEmpty()){
            val value = queue1.poll()
            for (index in xList.indices){
                val xDot = xList[index] + value.second
                val yDot = yList[index] + value.first
                if (xDot > n-1 || xDot < 0)
                    continue
                if (yDot > n-1 || yDot < 0)
                    continue
                if (visit1[yDot][xDot])
                    continue
                if (arr[yDot][xDot] == arr[value.first][value.second]){
                    queue1.add(Pair(yDot,xDot))
                    visit1[yDot][xDot] = true
                }
            }
        }

        count1 += 1
    }
    fun bfs2(y: Int, x:Int){
        queue2.add(Pair(y,x))
        visit2[y][x] = true
        while(queue2.isNotEmpty()){
            val value = queue2.poll()
            for (index in xList.indices){
                val xDot = xList[index] + value.second
                val yDot = yList[index] + value.first
                if (xDot > n-1 || xDot < 0)
                    continue
                if (yDot > n-1 || yDot < 0)
                    continue
                if (visit2[yDot][xDot])
                    continue
                if (arr[value.first][value.second] == "R" || arr[value.first][value.second] == "G"){
                    if (arr[yDot][xDot] == "R" || arr[yDot][xDot] == "G"){
                        queue2.add(Pair(yDot,xDot))
                        visit2[yDot][xDot]  = true
                    }
                }
                else{
                    if (arr[yDot][xDot] == arr[value.first][value.second]){
                        queue2.add(Pair(yDot,xDot))
                        visit2[yDot][xDot] = true
                    }
                }
            }
        }

        count2 += 1
    }
    for (y in arr.indices){
        for (x in arr.indices){
            if (!visit1[y][x])
                bfs1(y,x)
            if (!visit2[y][x])
                bfs2(y,x)

        }
    }
    println(count1)
    println(count2)
}