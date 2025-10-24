package thirtyfirst_fourtieth.thirtySecond
import java.io.*
import kotlin.system.exitProcess

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = Array(9){0}
    repeat(9){
        list[it] = br.readLine().toInt()
    }
    val arr = Array(7){0}
    val visit = Array(9){false}
    fun dfs(num: Int){
        if (num == 7){
            if (arr.sum() == 100){
                arr.sorted().forEach{println(it)}
                exitProcess(0)
            }
            return
        }
        for (index in list.indices){
            if (!visit[index]){
                arr[num] = list[index]
                visit[index] = true
                dfs(num+1)
                visit[index] = false
            }
        }
    }
    dfs(0)
}