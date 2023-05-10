package thirtyfirst_fourtieth.thirtynineth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    while(true){
        val (w,h) = br.readLine().split(' ').map{it.toInt()}
        val arr = Array(h){Array(w){0} }
        if (w == 0)
            break
        repeat(h){
            val input = br.readLine().split(' ').map{it.toInt()}
            for (index in input.indices){
                arr[it][index] = input[index]
            }
        }
        val xList = arrayListOf(-1, 0, 1, -1, 1, -1, 0, 1)
        val yList = arrayListOf(-1, -1, -1, 0, 0, 1, 1, 1)
        var count = 0

        val visit = Array(h){Array(w){false}}

        val queue = LinkedList<Pair<Int,Int>>()

        for (i in arr.indices){
            for (j in arr[i].indices){
                if (!visit[i][j] && arr[i][j] == 1){
                    queue.add(Pair(i,j))
                    while(queue.isNotEmpty()){
                        val first = queue.poll()
                        for (index in xList.indices){
                            val xIn = xList[index] + first.second
                            val yIn = yList[index] + first.first
                            if (xIn in 0 until w && yIn in 0 until h){
                                if (arr[yIn][xIn] == 1 && !visit[yIn][xIn]){
                                    queue.add(Pair(yIn,xIn))
                                    visit[yIn][xIn] = true
                                }
                            }
                        }
                    }
                    count++
                }
            }
        }
        println(count)
    }


}