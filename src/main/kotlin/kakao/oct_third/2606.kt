package kakao.oct_third

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()
    val num1 = br.readLine().toInt()

    val computers = Array(num + 1){ mutableListOf<Int>() }
    val visit = Array(num + 1){false}
    repeat(num1){
        val (a,b) = br.readLine().split(' ').map { it.toInt() }
        computers[a].add(b)
        computers[b].add(a)
    }

    fun dfs(node: Int){
        for (next in computers[node]){
            if (!visit[next]) {
                visit[next] = true
                dfs(next)
            }
        }
    }

    visit[1] = true
    dfs(1)

    println(visit.count{ it } - 1)
}