package eleventh_twentieth.eleventhDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(m){0}
    val visit = Array(n+1){false}
    fun dfs(num: Int, lastNum: Int){
        if (num == m){
            arr.forEach{print("$it ")}
            println()
            return
        }

        for (index in 1..n){
            if (!visit[index]){
                if (index <= lastNum)
                    continue
                visit[index] = true
                arr[num] = index
                dfs(num + 1, index)
                visit[index] = false
            }
        }
    }
    dfs(0, 0)
}