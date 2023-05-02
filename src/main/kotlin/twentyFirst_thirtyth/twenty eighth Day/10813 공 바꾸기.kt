package twentyFirst_thirtyth.`twenty eighth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){0}
    for (index in arr.indices){
        arr[index] = index+1
    }

    repeat(m){
        val (i,j) = br.readLine().split(' ').map{it.toInt()}
        val temp = arr[i-1]
        arr[i-1] = arr[j-1]
        arr[j-1] = temp
    }
    arr.forEach{print("$it ")}
}