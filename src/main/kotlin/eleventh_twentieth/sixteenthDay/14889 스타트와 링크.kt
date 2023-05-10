package eleventh_twentieth.sixteenthDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var valueArr = Array(n+1){Array(n+1){0} }
    repeat(n){
        val string = StringTokenizer(br.readLine())
        for (index in 1..n){
            valueArr[it+1][index] = string.nextToken().toInt()
        }
    }
    val visit = Array(n+1){false}
    val ans = Array(n){0}
    var finalValue = Int.MAX_VALUE
    fun dfs(num: Int){
        if (num == n){
            var start = 0
            var link = 0
            for (index in 0 until n/2){
                for (index1 in index+1 until n/2){
                    link += valueArr[ans[index+n/2]][ans[index1+n/2]] + valueArr[ans[index1+n/2]][ans[index+n/2]]
                    start += valueArr[ans[index]][ans[index1]] + valueArr[ans[index1]][ans[index]]
                }
            }
            val v = Math.abs(start - link)
            if (finalValue == 0){
                println(0)
                System.exit(0)
            }
            if (finalValue >= v)
                finalValue = v
            return
        }// 6    6
        for (index in 1 ..n){
            if (!visit[index]){
                visit[index] = true
                ans[num] = index
                dfs(num+1)
                visit[index] = false
            }
        }
    }
    dfs(0)
    println(finalValue)
}
