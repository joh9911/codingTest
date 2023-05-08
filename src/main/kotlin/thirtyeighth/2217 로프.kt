package thirtyeighth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){0}
    repeat(n){
        arr[it] = br.readLine().toInt()
    }
    arr.sort()
    var min = 0
    for (index in 0 until n){
        min = Math.max(arr[index]*(n-index), min)
    }
    println(min)
}