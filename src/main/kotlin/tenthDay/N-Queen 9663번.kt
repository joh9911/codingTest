package tenthDay
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val depth = Array(n){false}
    val ans = Array(n){0}
    var count = 0
    fun dfs(num: Int,prevIndex: Int){
        if (num == n){
            count += 1
            return
        }
        for (index in 0 until n){
            if (!depth[index]){
                var tag = false
                for (index1 in prevIndex downTo 0){
                    if (Math.abs(index - ans[index1]) == num - index1){
                        tag =  true
                        break
                    }
                }
                if (tag)
                    continue
                depth[index] = true
                ans[num] = index
                dfs(num + 1, num)
                depth[index] = false
            }
        }
    }
    dfs(0, -2)
    println(count)
}
// 0 x 0 0
// 0 0 0 x
// 0 0 x 0