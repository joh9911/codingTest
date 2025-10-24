package thirtyfirst_fourtieth.thirtysixth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(2){0}
    val visit = Array(n){false}
    var count = 0

    fun dfs(num: Int){
        if (num == 2){
//            arr.forEach{print("$it ")}
//            println()
            if (arr.sum() == m)
                count++
            return
        }
        for (index in visit.indices){
            if (!visit[index]){
                visit[index] = true
                arr[num] = list[index]
                dfs(num + 1)
                visit[index] = false
            }
        }
    }
    dfs(0)
    println(count / 2)

}