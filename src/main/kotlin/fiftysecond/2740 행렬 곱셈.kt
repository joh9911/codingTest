import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    var st = StringTokenizer(br.readLine(), " ")

    // A행렬 입력
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val A = Array(N) { IntArray(M) }
    for (i in 0 until N) {
        st = StringTokenizer(br.readLine(), " ")
        for (j in 0 until M) {
            A[i][j] = st.nextToken().toInt()
        }
    }
    st = StringTokenizer(br.readLine(), " ")

    // B행렬 입력
    st.nextToken()
    val K = st.nextToken().toInt()
    val B = Array(M) { IntArray(K) }
    for (i in 0 until M) {
        st = StringTokenizer(br.readLine(), " ")
        for (j in 0 until K) {
            B[i][j] = st.nextToken().toInt()
        }
    }

    // 행렬 계산 및 출력
    for (i in 0 until N) {
        for (j in 0 until K) {
            var sum = 0
            for (k in 0 until M) {
                sum += A[i][k] * B[k][j]
            }
            sb.append(sum).append(' ')
        }
        sb.append('\n')
    }
    println(sb)
}
