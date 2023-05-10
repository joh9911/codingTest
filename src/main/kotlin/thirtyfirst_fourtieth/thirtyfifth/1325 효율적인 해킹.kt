package thirtyfirst_fourtieth.thirtyfifth
import java.io.*
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val map = Array(n+1){arrayListOf<Int>()}
    repeat(m){
        val token = StringTokenizer(br.readLine())
        val a = token.nextToken().toInt()
        val b = token.nextToken().toInt()
        map[b].add(a)
    }
    val countArr = Array(n+1){0}
    var maxCount = 0


    for (index in 1..n){

        val visit = Array(n+1){false}

        val queue = LinkedList<Int>()

        queue.add(index)
        var count = 0

        while (queue.isNotEmpty()){
            val first = queue.poll()
//            map[first].forEach{
//                if (!visit[it]){
//                    visit[it] = true
//                    queue.add(it)
//                    count+=1
//                }
//            }
            if (!visit[first]){
                visit[first] = true
                count += 1
                map[first].forEach{queue.add(it)}
            }
        }
        maxCount = Math.max(count, maxCount)
        countArr[index] = count

    }
    for (index in countArr.indices){
        if (countArr[index] == maxCount)
            bw.write("$index ")
    }
    bw.flush()
}
