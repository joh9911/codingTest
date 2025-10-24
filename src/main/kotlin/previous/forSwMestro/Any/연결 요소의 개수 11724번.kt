package Any
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n+1){ArrayList<Int>()}
    val visit = Array(n+1){false}
    repeat(m){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        arr[a].add(b)
        arr[b].add(a)
    }
    val queue = LinkedList<Int>()
    var count = 0
    fun bfs(num: Int){
        queue.add(num)
        visit[num] = true
        while (queue.isNotEmpty()){
            val value = queue.poll()
            for (index in arr[value]){
                if (!visit[index]){
                    visit[index] = true
                    queue.add(index)
                }
            }
        }
        count += 1
    }
    for (index in 1..n){
        if (!visit[index]){
            bfs(index)
        }

    }
    println(count)
}
