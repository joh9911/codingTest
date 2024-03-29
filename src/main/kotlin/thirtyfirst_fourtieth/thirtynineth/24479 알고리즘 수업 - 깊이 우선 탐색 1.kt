package thirtyfirst_fourtieth.thirtynineth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, r) = br.readLine().split(' ').map{it.toInt()}
    //                      이 부분 입니다.
    val mp = Array(n+1){PriorityQueue<Int>()}
    repeat(m){
        val (u,v) = br.readLine().split(' ').map{it.toInt()}
        mp[u].add(v)
        mp[v].add(u)
    }
//
//    for (index in mp.indices){
//        mp[index].sort()
//    }

    val visit = Array(n+1){0}
    var count = 1
    fun dfs(start: Int){
        visit[start] = count
        for (child in mp[start]){
            if (visit[child] == 0){
                count++
                dfs( child)
            }
        }
    }
    dfs(r)
    for (index in 1..n){
        println(visit[index])
    }


}