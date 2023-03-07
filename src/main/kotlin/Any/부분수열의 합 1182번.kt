package Any
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,s) = br.readLine().split(' ').map{it.toInt()}
    val list = br.readLine().split(' ').map{it.toInt()}
    val visit = Array(n){false}
    val ans = Array(n){0}
    fun dfs(num: Int, prevIdx: Int){
        if (num == n){
            ans.forEach{print("$it ")}
            println()
            return
        }
        for (index in list.indices){
            if (!visit[index]){
//                if (prevIdx > index)
//                    continue
                visit[index] = true
                ans[num] = list[index]
                dfs(num+1, index)
                visit[index] = false
            }
        }
    }
    dfs(0,-1)
}