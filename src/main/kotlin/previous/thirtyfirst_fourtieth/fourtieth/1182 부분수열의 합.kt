package thirtyfirst_fourtieth.fourtieth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,s) = br.readLine().split(' ').map{it.toInt()}
    val list = br.readLine().split(' ').map{it.toInt()}

    var count = 0

    fun dfs(num: Int, targetNum: Int, visit: Array<Boolean>, arr: Array<Int>, prevIdx: Int){
        if (num == targetNum){
            if (arr.sum() == s){
//                arr.forEach{print("$it ")}
//                println()
                count += 1
            }
            return
        }
        for (index in list.indices){
            if(!visit[index]){
                if (prevIdx > index) continue
                visit[index] = true
                arr[num] = list[index]
                dfs(num+1, targetNum, visit, arr, index)
                visit[index] = false
            }
        }
    }
    for (index in list.indices){
        if (list[index] == s)
            count++
    }
    if (list.size != 1){
        if (list.sum() == s)
            count += 1
    }



    for (index in 2 until n){
        val arr = Array(index){0}
        val visit = Array(n){false}
        dfs(0, index, visit, arr, - 100001)
    }
    println(count)




// -7 -10 -12 -7 1
}
