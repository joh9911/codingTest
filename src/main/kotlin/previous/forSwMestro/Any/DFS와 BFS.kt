package Any
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m,v) = br.readLine().split(' ').map{it.toInt()}
    val ans = Array(n){0}
    val visit = Array(n+1){false}
    val edges = Array(n+1){ArrayList<Int>()}
    repeat(m){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        edges[a].add(b)
        edges[b].add(a)
    }
    edges.forEach{it.sort()}

    fun dfs(idx: Int){
        print("$idx ")
        visit[idx] = true
        for (index in edges[idx]){
            if (!visit[index]){
                visit[index] = true
                dfs(index)
            }
        }
    }
    dfs(v)
    println()
    visit.fill(false)
    val queue = LinkedList<Int>()
    fun bfs(first: Int){
        queue.add(first)
        visit[first] = true
        while (!queue.isEmpty()){
            val value = queue.poll()
            print("$value ")
            for (index in edges[value]){
                if (!visit[index]){
                    queue.add(index)
                    visit[index] = true
                }
            }
        }
    }
    bfs(v)
}