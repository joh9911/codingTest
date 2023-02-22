package eleventhDay
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(' ').map { it.toInt() }
    val arr = Array(n) { Array(m) { 0 } }
    repeat(n) { i ->
        val input = br.readLine().split(' ').map { it.toInt() }
        for (index in input.indices) {
            arr[i][index] = input[index]
        }
    }
    var count = 0
    var temp = 0
    val addList = mutableListOf<Pair<Int,Int>>()
    fun func(num: Int, count: Int){
        if (addList.isEmpty())
            return
    }
    while (true) {
        for (index in arr.indices) {
            for (index1 in arr[index].indices) {
                if (arr[index][index1] == 1) {
                    if (index1 - 1 >= 0) {
                        if (arr[index][index1 - 1] != 1 && arr[index][index1 - 1] != -1)
                            addList.add(Pair(index,index1-1))
                    }
                    if (index1 + 1 <= arr[index].size - 1) {
                        if (arr[index][index1 + 1] != 1 && arr[index][index1 + 1] != -1)
                            addList.add(Pair(index,index1+1))
                    }
                    if (index - 1 >= 0) {
                        if (arr[index - 1][index1] != 1 && arr[index - 1][index1] != -1)
                            addList.add(Pair(index-1,index1))
                    }
                    if (index + 1 <= arr.size - 1) {
                        if (arr[index + 1][index1] != 1 && arr[index + 1][index1] != -1)
                            addList.add(Pair(index+1,index1))
                    }
                }
                if (arr[index][index1] == 0)
                    temp += 1
            }
        }
        if (addList.isEmpty())
            break
        addList.forEach{arr[it.first][it.second] = 1}
        addList.clear()
        temp = 0
        count += 1
    }
    if (temp == 0)
        println(count)
    else
        println(-1)

}