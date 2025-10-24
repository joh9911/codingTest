package now.fifth_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, x) = br.readLine().split(' ').map { it.toInt() }
    val list = br.readLine().split(' ').map { it.toInt() }

    val result = IntArray(list.size)
    for (index in list.indices){
        var sum = 0
        for (i in index until index + x){
            if (i >= n) continue
            sum += list[i]
        }
        result[index] = sum
    }
    

    val resultMax = result.max()
    for (index in result.indices){
        if (result[index] == resultMax){
        }
    }
}