package eleventhDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val list = br.readLine().split(' ').map{it.toInt()}.sorted()
    val ans = Array(3){0}
    val depth = Array(n){false}
    val list1 = Vector<Int>()
    fun dfs(num: Int){
        if (num == 3){
            val value = ans.sum()
            if (value <= m)
                list1.add(value)
            return
        }
        for (index in list.indices){
            if (!depth[index]){
                depth[index] = true
                ans[num] = list[index]
                dfs(num+1)
                depth[index] = false
            }
        }
    }
    dfs(0)
    println(list1.max())
}
