package twentyFirst_thirtieth.`twenty first Day`

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){Array(n){0} }
    repeat(n){
        val list = br.readLine().split(' ')
        for (index in list.indices){
            arr[it][index] = list[index].toInt()
        }
    }
    for (index in 1 until n){
        arr[index][0] += arr[index - 1][0]
        for (index1 in 1 until index){
            arr[index][index1] += Math.max(arr[index-1][index1-1], arr[index-1][index1])
        }
        arr[index][index] += arr[index-1][index-1]
    }
    println(arr[n-1].max())

}