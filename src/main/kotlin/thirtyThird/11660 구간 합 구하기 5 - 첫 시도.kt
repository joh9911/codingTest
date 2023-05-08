package thirtyThird
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){Array(n){0} }
    var prevNum = 0
    repeat(n){i ->
        val token = StringTokenizer(br.readLine())
        arr[i][0] = token.nextToken().toInt() + prevNum
        for (index in 1 until n){
            arr[i][index] = arr[i][index-1] + token.nextToken().toInt()
        }
        prevNum = arr[i].last()
    }
    println()
    for (index in arr.indices){
        for (index1 in arr[index].indices){
            print("${arr[index][index1]} ")
        }
        println()
    }

    repeat(m){
        val token = StringTokenizer(br.readLine())

        val x1 = token.nextToken().toInt() - 1
        val y1 = token.nextToken().toInt() - 1
        val x2 = token.nextToken().toInt() - 1
        val y2 = token.nextToken().toInt() - 1

        var sum = 0
        if (y1 == 0){
            for (index in x1..x2){
                sum +=
                    if (index == 0)
                        arr[index][y2]
                    else
                        arr[index][y2] - arr[index-1][n-1]
            }
        }
        else{
            for (index in x1..x2){
                sum +=
                    arr[index][y2] - arr[index][y1-1]

            }
        }

        bw.write("$sum\n")

    } // 42 - 27 - 12 + 24
    bw.flush()
}
//27
// 12 + 9 + 6

