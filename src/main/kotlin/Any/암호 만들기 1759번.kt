package Any
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (l,c) = br.readLine().split(' ').map{it.toInt()}
    val list1 = listOf("a","e","i","o","u")
    val stringList = br.readLine().split(' ').sorted()
    val visit = Array(c){false}
    val ans = Array(l){""}
    fun dfs(num: Int, prevChar: String){
        if (num == l){
            val count1 = ans.count{list1.contains(it)}
            if (count1 < 1)
                return
            if (l-count1 < 2)
                return
            ans.forEach{print(it)}
            println()
            return
        }
        for (index in stringList.indices){
            if (!visit[index]){
                if (prevChar > stringList[index]){
                    continue
                }
                visit[index] = true
                ans[num] = stringList[index]
                dfs(num+1, stringList[index])
                visit[index] = false
            }
        }
    }
    dfs(0, "a")
}
