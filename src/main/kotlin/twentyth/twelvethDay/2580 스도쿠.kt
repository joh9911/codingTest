package twentyth.twelvethDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val place = arrayListOf<Pair<Int,Int>>()
    val arr = Array(9){Array(9){0} }
    val visit = Array(10){Array(10){false} }
    repeat(9){
        val input = br.readLine().split(' ').map{num-> num.toInt()}
        for (index in input.indices){
            arr[it][index] = input[index]
            if (input[index] == 0)
                place.add(Pair(index, it))
            else
                visit[it+1][input[index]] = true
        }
    }
    for (index in arr.indices){
        for (index1 in arr[index].indices){
            print("${arr[index][index1]} ")
        }
        println()
    }
    println()
    fun dfs(num: Int){
        if (num == place.size)
            return
        for (index in 1 .. 9){
            if (!visit[place[num].second+1][index]){

                arr[place[num].second][place[num].first] = index
                visit[place[num].second+1][index] = true
                dfs(num + 1)
                visit[place[num].second+1][index] = false
            }
        }
    }
    dfs(0)
    for (index in arr.indices){
        for (index1 in arr[index].indices){
            print("${arr[index][index1]} ")
        }
        println()
    }
}