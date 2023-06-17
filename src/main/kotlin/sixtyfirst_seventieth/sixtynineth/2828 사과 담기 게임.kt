package sixtyfirst_seventieth.sixtynineth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){0}
    var count = 0
    for (index in 0 until m){
        arr[index] = 1
    }
    val j = br.readLine().toInt()
    repeat(j){
        var first = 0
        var last = 0
        for (index in arr.indices){
            if (arr[index] == 1){
                first = index
                break
            }
        }
        for (index in arr.size - 1 downTo 0){
            if (arr[index] == 1){
                last = index
                break
            }
        }
        val num = br.readLine().toInt() - 1
        if (num < first){
            count += Math.abs(first - num)
            for (index in arr.indices) arr[index] = 0
            for (index in num until num + m) arr[index] = 1
        }
        else if (num > last){
            count += Math.abs(last - num)
            for (index in arr.indices) arr[index] = 0
            for (index in num downTo num - m + 1) arr[index] = 1
        }
    }
    println(count)
}