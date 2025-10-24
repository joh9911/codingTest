package tenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val ans = Array(m){0}
    fun dfs(num: Int, prevNum: Int){
        if (num == m){
            ans.forEach{bw.write("$it ")}
            bw.write("\n")
            return
        }
        for (index in 1.. n){
            if (prevNum > index)
                continue
            ans[num] = index
            dfs(num + 1,ans[num])
        }
    }
    dfs(0, 0)
    bw.flush()
}