package twentyFirst_thirtyth.`twenty nineth Day`
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    if (m == 0){
        if (Math.abs(n-100) <= n.toString().length)
            println(Math.abs(n-100))
        else
            println(n.toString().length)
    }
    else{
        val list = br.readLine().split(' ').map{it.toInt()}
        val visit = Array(10){false}
        val arr = Array(6){0}
        for (index in list.indices){
            visit[list[index]] = true
        }
        var min = 500001
        var value = 500001
        fun dfs(num: Int, prevNum: Int){
            if (num == 6){
                var stringNum = ""
                arr.forEach{
                    stringNum += it
                }
                if (Math.abs(n - stringNum.toInt()) < min){
                    min = Math.abs(n - stringNum.toInt())
                    value = stringNum.toInt()
                }
                return
            }

            for (index in 0..9){
                if (index == 0 && !visit[index]){

                }
                if (!visit[index]){
                    arr[num] = index
                    dfs(num + 1, index)
                }
            }
        }
        if (Math.abs(n-100) <= n.toString().length)
            println(Math.abs(n-100))
        else{
            dfs(0, -1)
            println(min+value.toString().length)
        }
    }

}