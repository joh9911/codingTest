package now.third_day

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){Array(n){' '} }


    for (i in 0 until n){
        val input = br.readLine()
        for (j in 0 until n){
            arr[i][j] = input[j]
        }
    }

    fun swap(i: Int, j: Int, i1: Int, j1: Int){
        val temp = arr[i][j]
        arr[i][j] = arr[i1][j1]
        arr[i1][j1] = temp
    }

    fun countCandy(): Int{
        var maxCount = 1
        for (i in 0 until n){
            var count = 1
            for (j in 1 until n){
                if (arr[i][j] == arr[i][j-1]){
                    count ++
                }else{
                    maxCount = Math.max(maxCount, count)
                    count = 1
                }
            }
            maxCount = Math.max(maxCount, count)

        }
        for (i in 0 until n){
            var count = 1
            for (j in 1 until n){
                if (arr[j][i] == arr[j-1][i]){
                    count ++
                }else{
                    maxCount = Math.max(maxCount, count)
                    count = 1
                }
            }
            maxCount = Math.max(maxCount, count)

        }
        return maxCount
    }

    var realMax = 0
    for (i in 0 until n){
        for (j in 0 until n){
            if (j + 1 < n) {
                swap(i, j, i, j+1)
                realMax = Math.max(countCandy(),realMax)
                swap(i, j, i, j+1)
            }
            if (i + 1 < n){
                swap(i, j, i + 1, j)
                realMax = Math.max(countCandy(),realMax)
                swap(i, j, i + 1, j)
            }
        }
    }

    println(realMax)

}