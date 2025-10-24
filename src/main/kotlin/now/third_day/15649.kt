package now.third_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(m){0}
    val visit = Array(n + 1){false}

    fun dfs(depth: Int){
        if (depth == m){
            arr.forEach {
                print("$it ")
            }
            println()
            return
        }
        for (index in 1..n){
            if (visit[index]) continue
            visit[index] = true
            arr[depth] = index
            dfs(depth + 1)
            visit[index] = false
        }
    }
    dfs(0)


}