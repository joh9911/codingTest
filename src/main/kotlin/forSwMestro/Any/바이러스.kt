package Any
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()
    val lineCount = br.readLine().toInt()
    val arr = Array(count+1){arrayListOf<Int>()}
    val visit = Array(count+1){false}
    repeat(lineCount){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        arr[a].add(b)
        arr[b].add(a)
    }
    val queue = LinkedList<Int>()
    var count1 = -1
    fun bfs(start: Int){
        queue.add(start)
        visit[start] = true
        while (queue.isNotEmpty()){
            count1 += 1
            val value = queue.poll()
            for (index in arr[value]){
                if (!visit[index]){
                    visit[index] = true
                    queue.add(index)
                }
            }
        }
    }
    bfs(1)
    println(count1)
}