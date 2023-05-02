package thirtyFirst
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val bag = arrayListOf<Pair<Int, Int>>()
    repeat(n) {
        val (w, v) = br.readLine().split(' ').map { it.toInt() }
        bag.add(Pair(w, v))
    }
    bag.sortWith(compareBy<Pair<Int,Int>>{it.first}.thenBy{it.second})
   bag.forEach{print("$it ")}
    println()
    val dp = Array(n){Pair(0,0)}
    if (bag.first().first <= k)
        dp[0] = bag.first()
    for (index in 1 until bag.size){
        if (dp[index-1].first + bag[index].first > k){
            var max = 0
            for (index1 in index-1 downTo 0){
                val second = dp[index-1].second - bag[index1].second + bag[index].second
                val first = dp[index-1].first - bag[index1].first+bag[index].first
                if (first <= k){
                    if (max <= second){
                        max = second
                        dp[index] = Pair(first,second)
                    }
                }
                else
                    dp[index] = dp[index-1]
            }
        }
        else{
            dp[index] = Pair(bag[index].first+dp[index-1].first, bag[index].second+dp[index-1].second)
        }
    }
    dp.forEach{print("$it ")}
    println()
    println(dp.maxBy{it.second}.second)
    //77
}