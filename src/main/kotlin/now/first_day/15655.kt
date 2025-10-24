package now.first_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }.sorted()
    val visit = Array(n + 1){false}
    val arr = Array(m){0}

    fun dfs(n: Int, m: Int, depth: Int, arr: Array<Int>){
        if (depth == m){
            arr.forEach {
                print("$it ")
            }
            println()
            return
        }

        for (index in list.indices){
            if (visit[index]) continue
            if (depth >= 1 && arr[depth - 1] > list[index]) continue
            arr[depth] = list[index]
            visit[index] = true
            dfs(n, m, depth + 1, arr)
            visit[index] = false
        }
    }
    dfs(n, m, 0, arr)
}