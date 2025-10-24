package now.first_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val visit = Array(m + 1) { false }
    val arr = Array(n) { 0 }  // n개의 숫자를 저장할 배열

    fun dfs(m: Int, n: Int, num: Int, depth: Int, arr: Array<Int>) {
        if (depth == n) {
            arr.forEach {
                print("$it ")
            }
            println()
            return
        }

        for (index in num..m) {
            if (!visit[index]) {
                arr[depth] = index
                visit[index] = true
                dfs(m, n, index + 1, depth + 1, arr)  // 여기서 index + 1로 다음 숫자부터 탐색
                visit[index] = false
            }
        }
    }

    dfs(m, n, 1, 0, arr)  // 초기 배열과 탐색 시작
}
