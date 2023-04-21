package twentyth.eleventhDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array<Int>(m){0}
    fun dfs(num: Int){
        if (num == m){
            arr.forEach{print("$it ")}
            println()
            return
        }
        for (index in 1..n){
            arr[num] = index
            dfs(num + 1)
        }
    }
    dfs(0)
}