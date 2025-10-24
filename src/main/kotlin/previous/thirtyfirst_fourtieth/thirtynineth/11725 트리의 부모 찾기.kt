package thirtyfirst_fourtieth.thirtynineth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val mp = Array(n+1){arrayListOf<Int>()}
    repeat(n-1){
        val token = StringTokenizer(br.readLine())
        val a = token.nextToken().toInt()
        val b = token.nextToken().toInt()
        mp[a].add(b)
        mp[b].add(a)
    }

    val parent = Array(n+1){0}
    val queue = LinkedList<Int>()
    parent[1] = 1
    queue.add(1)
    while(queue.isNotEmpty()){
        val first = queue.poll()
        for (child in mp[first]){
            if (parent[child] == 0){
                parent[child] = first
                queue.add(child)
            }
        }

    }

    for (index in 2..n){
        bw.write("${parent[index]}\n")
    }

    bw.flush()
}