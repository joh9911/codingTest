package eleventh_twentieth.eleventhDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(m){0}
    fun dfs(num: Int, prevNum: Int){
        if (num == m){
            arr.forEach{print("$it ")}
            println()
            return
        }
        for (index in 1..n){
            if (prevNum > index)
                continue
            arr[num] = index
            dfs(num+1, index)
        }
    }
    dfs(0,1)
}