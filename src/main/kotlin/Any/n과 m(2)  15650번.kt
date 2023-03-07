package Any
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val ans = Array(m){0}
    val visit = Array(n+1){false}
    fun dfs(num: Int, prevNum: Int){
        if (num == m){
            ans.forEach{print("$it ")}
            println()
            return
        }
        for (index in 1..n){
            if (!visit[index]){
                if (prevNum > index)
                    continue
                visit[index] = true
                ans[num] = index
                dfs(num + 1, index)
                visit[index] = false
            }
        }
    }
    dfs(0,0)
}