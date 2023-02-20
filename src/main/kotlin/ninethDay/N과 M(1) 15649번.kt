package ninethDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val ans = Array(m){0}
    val depth = Array(n+1){false}
    fun dfs(num: Int){
        if (num == m){
            ans.forEach{print("$it ")
            }
            print("\n")
            return
        }
        for (index in 1 .. n){
            if (!depth[index]){
                depth[index] = true
                ans[num] = index
                dfs(num+1)
                depth[index] = false
            }
        }
    }
    dfs(0)

}