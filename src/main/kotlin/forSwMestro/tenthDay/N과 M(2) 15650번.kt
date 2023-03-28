package tenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val ans = Array(m){0}
    val depth = Array(n+1){false}

    fun dfs(num: Int, prevNum: Int){
        if (num == m){
            ans.forEach{print("$it ") }
            print("\n")
            return
        }
        for (index in 1.. n){
            if (!depth[index]){
                if (prevNum > index)
                    continue
                ans[num] = index
                depth[index] = true
                dfs(num+1, ans[num])
                depth[index] = false
            }
        }
    }
    dfs(0, 0)
}