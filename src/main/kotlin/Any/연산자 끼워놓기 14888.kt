package Any
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val aNumbers = br.readLine().split(' ').map{it.toInt()}
    val nNumbers = br.readLine().split(' ').map{it.toInt()}
    val ans = Array(n-1){0}
    val depth = mutableMapOf<Int,Int>()
    for (index in nNumbers.indices){
        depth[index] = nNumbers[index]
    }
    val value = mutableSetOf<Int>()

    fun dfs(num: Int){
        if (num == n-1){
            var temp = aNumbers[0]
            for (index in aNumbers.indices){
                if (index == aNumbers.size-1)
                    break
                if (ans[index] == 0)
                    temp += aNumbers[index + 1]
                else if(ans[index] == 1)
                    temp -= aNumbers[index + 1]
                else if (ans[index] == 2)
                    temp *= aNumbers[index + 1]
                else
                    temp /= aNumbers[index + 1]
            }
            value.add(temp)
            return
        }
        for (index in 0 until 4){
            if (depth[index] != 0){
                depth[index] = depth[index]!! - 1
                ans[num] = index
                dfs(num+1)
                depth[index] = depth[index]!! + 1
            }
        }
    }
    dfs(0)
    println(value.max())
    println(value.min())
}