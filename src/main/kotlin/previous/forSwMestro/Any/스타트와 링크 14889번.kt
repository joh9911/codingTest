package Any
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n+1){Array(n+1){0} }
    repeat(n){i ->
        val token = StringTokenizer(br.readLine())
        for (index in 1..n){
            arr[i+1][index] = token.nextToken().toInt()
        }
    }
    val v = Array(n+1){false}
    var min = Int.MAX_VALUE
    fun dfs(num: Int, idx: Int){
        if (num == n/2){
            var teamStart = 0
            var teamLink = 0
            for (index in 1 until n){
                for (index1 in index+1..n){
                    if (v[index] && v[index1]){
                        teamStart += arr[index][index1] + arr[index1][index]
                    }
                    else if (!v[index] && !v[index1]){
                        teamLink += arr[index][index1] + arr[index1][index]
                    }
                }
            }
            val diff = Math.abs(teamStart-teamLink)
            if (diff==0){
                println(0)
                System.exit(0)
            }
            min = Math.min(diff,min)
            return
        }
        for (index in idx..n){
            if (!v[index]){
                v[index] = true
                dfs(num+1, index+1)
                v[index] = false
            }
        }
    }
    dfs(0, 1)
    println(min)

}
// 원래는 dfs 할 때 인자를 num으로만 줬잖아
// 근데 이게 계속해서 시간 초과가 뜸
// index+1를 계속 인자로 넘겨서 for문에 넣어주면 시간이 절약되나봄