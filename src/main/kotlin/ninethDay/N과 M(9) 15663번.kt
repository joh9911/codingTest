package ninethDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val list =  br.readLine().split(' ').map{it.toInt()}.sorted()
    val ans = Array(m){0}
    val depth = Array(n){false}
    var temp = arrayOf(0,0)
    var tag =  false
    fun dfs(num: Int){
        if (num == m){
            for (index in ans.indices) {
                if (ans[index] != temp[index])
                    tag = true
                temp[index] = ans[index]
            }
            if (tag) {
                ans.forEach { bw.write("$it ") }
                bw.write("\n")
                tag = false
                return
            }
            else{
                tag = false
                return
            }
        }
        for (index in list.indices){
            if(!depth[index]){
                depth[index] = true
                ans[num] = list[index]
                dfs(num+1)
                depth[index] = false
            }
        }
    }
    dfs(0)
    bw.flush()
}