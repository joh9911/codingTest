package Any
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val list = br.readLine().split(' ').map { it.toInt() }.sorted()
    val ans = Array(m) { 0 }
    fun dfs(num: Int) {
        if (num == m) {
            ans.forEach { bw.write("$it ") }
            bw.write("\n")
            return
        }
        var remember = 0
        for (index in list.indices) {
            if (remember != list[index]) {
                remember = list[index]
                ans[num] = list[index]
                dfs(num + 1)
            }
        }
    }
    dfs(0)
    bw.flush()
}