import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val arr = Array(n) { IntArray(n) }
    val sum = Array(n + 1) { IntArray(n + 1) }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until n) {
            arr[i][j] = st.nextToken().toInt()
            sum[i + 1][j + 1] = arr[i][j] + sum[i][j + 1] + sum[i + 1][j] - sum[i][j]
        }
    }

    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()

        val querySum = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]
        bw.write("$querySum\n")
    }
    bw.flush()
}