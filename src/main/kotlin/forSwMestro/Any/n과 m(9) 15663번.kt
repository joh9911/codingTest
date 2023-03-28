package Any
import java.io.*
import kotlin.math.roundToInt

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
//    val (n, m) = br.readLine().split(' ').map { it.toInt() }
//    val list = br.readLine().split(' ').map { it.toInt() }.sorted()
//    val ans = Array(m){0}
//    val visit = Array(n){false}
//    fun dfs(num: Int){
//        if (num == m){
//            ans.forEach{bw.write("$it ")}
//            bw.write("\n")
//            return
//        }
//        var remember = 0
//        for (index in 0 until n){
//            if (!visit[index] && remember != list[index]){
//                visit[index] = true
//                ans[num] = list[index]
//                remember = list[index]
//                dfs(num+1)
//                visit[index] = false
//            }
//        }
//    }
//    dfs(0)
//    bw.flush()
    val num = br.readLine()
    println(num.toInt()/1000.0)
    fun viewCountCalculator(viewCountString: String): Int{
        val viewCount = viewCountString.toInt()
        var convertedViewCount = 0
            if (viewCount < 1000)
                convertedViewCount = viewCount.toInt()
            else if (viewCount in 1000..9999){
                convertedViewCount = ((viewCount/1000.0) * 10.0).roundToInt()
            }
            else if (viewCount in 10000 .. 99999){
                convertedViewCount = ((viewCount/10000.0) * 10.0).roundToInt()
            }
            else if (viewCount in 100000.. 999999){
                convertedViewCount = ((viewCount / 10000.0)*10.0).roundToInt()
            }
            else if (viewCount in 1000000..99999999){
                convertedViewCount = viewCount/1000000
            }
            else{
                convertedViewCount = ((viewCount/100000000.0) * 10.0).roundToInt()
            }

        return convertedViewCount
    }
    println(viewCountCalculator(num))

}