package fiftyfirst_sixtieth.fiftysecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val input = br.readLine().split(' ').map{it.toInt()}

    val ansArr = Array(n){0}
    val visit = Array(n + 1){false}

    var prevArr = listOf<Int>()
    fun dfs(num: Int){
        if (num == n){
            var tag = true
            for (index in ansArr.indices){
                if (ansArr[index] != input[index])
                    tag = false
            }
            if (tag){
                if (prevArr.isEmpty())
                    println(-1)
                else{
                    prevArr.forEach{
                        print("$it ")
                    }
                }
                System.exit(0)
            }
            else
                prevArr = ansArr.toList()
            return
        }
        for (index in 1..n){
            if (!visit[index]){
                visit[index] = true
                ansArr[num] = index
                dfs(num+1)
                visit[index] = false
            }
        }
    }
    dfs(0)

}