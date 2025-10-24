package fourtyfirst_fiftieth.fourtyfirst
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k, x) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n+1){arrayListOf<Int>()}
    val visit = Array(n+1){-1}
    repeat(m){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        arr[a].add(b)
    }

    val queue = LinkedList<Int>()
    queue.add(x)

    visit[x] = 0

    while(queue.isNotEmpty()){
        val target = queue.poll()

        for (next in arr[target]){
            if (visit[next] == -1){
                queue.add(next)
                visit[next] = visit[target] + 1
            }
        }
    }

    var tag = false
    for (index in 1..n){
        if (visit[index] == k){
            tag = true
            println(index)
        }
    }

    if (!tag)
        println(-1)



}
