package twentyth.twelvethDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){0}
    val visit = Array(n+1){false}
    var count = 0
    fun dfs(num: Int, prevNum: Int){
        if (num == n){
            count ++
            return
        }
        for (value1 in 1..n){
            if (!visit[value1]){
                var tag = false
                for (value2 in prevNum downTo 0) {
                    if (Math.abs(value1 - arr[value2]) == num - value2) {
                        tag = true
                        break
                    }
                }
                if (tag)
                    continue
                visit[value1] = true
                arr[num] = value1
                dfs(num+1, num)
                visit[value1] = false
            }
        }
    }
    dfs(0, -1)
    println(count)
}
// 배열 하나로 처리할 수 있다는 것을 깨달음
// 인접한 요소 끼리는 1 이상이 차이나야함
// 두 거리 요소 끼리는 2 이상이 차이나야함
// 어 쭉 보니깐 두 거리만큼 차이나면 퀸이 잡아먹을 수 있음

// 0 0 x 0  3 1 4 2
// x 0 0 0
// 0 0 0 x
// 0 x 0 0

// 0 0 0 x 0   1  5  3  5  3
// 0 x 0 0 0
// 0 0 0 0 x
// 0 0 x 0 0
// x 0 0 0 0

// 0 0 0 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 0