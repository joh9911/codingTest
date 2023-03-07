package Any
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()
    val lineCount = br.readLine().toInt()
    val edges = Array(count+1){ArrayList<Int>()}
    val visit = Array(count+1){false}
    repeat(lineCount){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        edges[a].add(b)
        edges[b].add(a)
    }
    val queue = LinkedList<Int>()
    var answer = -1
    fun bfs(start: Int){
        queue.add(start)
        visit[start] = true
        while (queue.isNotEmpty()){
            answer += 1
            val value = queue.poll()
            for (index in edges[value]){
                if (!visit[index]){
                    queue.add(index)
                    visit[index] = true
                }
            }
        }
    }
    bfs(1)
    println(answer)
}