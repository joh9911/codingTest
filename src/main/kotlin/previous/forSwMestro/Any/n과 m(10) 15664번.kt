package Any
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val list = br.readLine().split(' ').map { it.toInt() }.sorted()
    val ans = Array(m){0}
    val visit = Array(n){false}
    fun dfs(num: Int, prevNum: Int){
        if (num == m){
            ans.forEach{bw.write("$it ")}
            bw.write("\n")
            return
        }
        var remember = 0
        for (index in list.indices){
            if (!visit[index] && remember != list[index]){
                if (prevNum > list[index])
                    continue
                visit[index] = true
                ans[num] = list[index]
                remember = list[index]
                dfs(num+1, list[index])
                visit[index] = false
            }
        }
    }
    dfs(0, 0)
    bw.flush()
}