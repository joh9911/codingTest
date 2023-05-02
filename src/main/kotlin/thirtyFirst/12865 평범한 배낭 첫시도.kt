package thirtyFirst
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val bag = arrayListOf<Pair<Int,Int>>()
    repeat(n){
        val (w,v) = br.readLine().split(' ').map{it.toInt()}
        bag.add(Pair(w,v))
    }
    val arr = Array(n){Pair(0,0)}
    val visit = Array(n){false}
    var max = 0
    fun dfs(num: Int, prevSize: Int){
        if (num == n){
            var sum = 0
            arr.forEach{print("$it ")}
            println()
            arr.forEach{sum += it.second}
            max = Math.max(sum,max)
            return
        }
        for (index in bag.indices){
            if (!visit[index]){
                if ((prevSize + bag[index].first) > k){
                    arr[num] = Pair(0,0)
                    visit[index] = true
                    dfs(num + 1, prevSize)
                    visit[index] = false
                }
                else{
                    visit[index] = true
                    arr[num] = bag[index]
                    dfs(num + 1, prevSize + bag[index].first)
                    visit[index] = false
                }
            }
        }
    }
    dfs(0,0)
    println(max)
}