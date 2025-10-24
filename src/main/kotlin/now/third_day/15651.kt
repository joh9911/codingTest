package now.third_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(m){0}

    fun dfs(depth: Int){
        if (depth == m){
            arr.forEach {
                print("$it ")
            }
            println()
            return
        }
        for (index in 1..n){
            arr[depth] = index
            dfs(depth + 1)
        }
    }
    dfs(0)


}