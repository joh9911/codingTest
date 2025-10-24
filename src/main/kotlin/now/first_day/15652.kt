package now.first_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n){1}
    fun dfs(m: Int, n: Int,  depth: Int, arr: Array<Int>){
        if (depth == n){
            arr.forEach {
                print("$it ")
            }
            println()
            return
        }

        for (index in 1..m){
            if (depth >= 1)
                if (arr[depth - 1] > index) continue
            arr[depth] = index
            dfs(m, n, depth + 1,  arr)
        }

    }
    dfs(m, n, 0,  arr)
}