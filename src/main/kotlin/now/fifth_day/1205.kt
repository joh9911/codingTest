package now.fifth_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, score, p) = br.readLine().split(' ').map { it.toInt() }
    if (n != 0){

        val arr = br.readLine().split(' ').map { it.toInt() }.toMutableList()
        arr.add(score)
        arr.sortDescending()
        var prev = arr.first()
        val rankArr = Array(n + 1){1}
        for (index in 1 until arr.size){
            val current = arr[index]
            if (current < prev){
                rankArr[index] = index + 1
            }
            else if (current == prev){
                rankArr[index] = rankArr[index - 1]
            }
            prev = current
        }

        for (index in arr.size - 1 downTo  0){
            if (arr[index] == score){
                if (index + 1 <= p){
                    println(rankArr[index])
                    return
                }
                else{
                    println(-1)
                    return
                }
            }
        }

    }
    else{
        println(1)
    }

}