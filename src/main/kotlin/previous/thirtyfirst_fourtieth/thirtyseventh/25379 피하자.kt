import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main(){
    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val st = StringTokenizer(br.readLine())
        var cntL: Long = 0
        var cntR: Long = 0
        var sum: Long = 0
        var idx = 0
        for (i in 0 until n) {
            val cur = st.nextToken().toInt()
            if (cur % 2 == 0) {
                sum += idx++.toLong()
                cntL += i.toLong()
                cntR += (n - 1 - i).toLong()
            }
        }
        println(Math.min(cntL, cntR) - sum)
    }
    solution()
}

