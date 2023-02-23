package eleventhDay
import java.io.*
import java.util.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(' ').map { it.toInt() }
    val arr = Array(n) { Array(m) { 0 } }
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)
    val addList = LinkedList<Pair<Int,Int>>()
    repeat(n) { i ->
        val input = br.readLine().split(' ').map { it.toInt() }
        for (index in input.indices) {
            if (input[index] == 1)
                addList.add(Pair(i,index))
            arr[i][index] = input[index]
        }
    }
    fun bfs(): Int{
        var count = 0
        while (addList.size != 0 ){
            val num = addList.poll()
            for (index in dx.indices){
                val numX = num.second + dx[index]
                val numY = num.first + dy[index]
                if (numX < 0 || numX >= m || numY < 0 || numY >= n)
                    continue
                if (arr[numY][numX] != 0)
                    continue
                arr[numY][numX] = arr[num.first][num.second] + 1
                addList.add(Pair(numY,numX))
            }

        }

        for (index in arr.indices){
            for (index1 in arr[index].indices){
                if (arr[index][index1] == 0){
                    return -1
                }
                count = Math.max(count, arr[index][index1])
            }
        }
        return count-1
    }

    println(bfs())

}