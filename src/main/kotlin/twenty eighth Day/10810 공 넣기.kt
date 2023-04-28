package `twenty eighth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){0}
    repeat(m){
        val (i,j,k) = br.readLine().split(' ').map{it.toInt()}
        for (index in i-1 until j){
            arr[index] = k
        }
    }
    arr.forEach{print("$it ")}
}
