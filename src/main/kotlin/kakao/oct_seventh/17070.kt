package kakao.oct_seventh

import kakao.oct_seventh.CurrentState.*
import java.io.BufferedReader
import java.io.InputStreamReader

enum class CurrentState{
    가로,
    세로,
    대각선
}
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val map = Array(n + 1){ Array(n + 1){ 0 } }
    for (i in 1 .. n){
        val input = br.readLine().split(' ')
        for (j in input.indices){
            map[i][j + 1] = input[j].toInt()
        }
    }
    var answer = 0

    fun dfs(y: Int, x: Int, currentState: CurrentState){
        if (x < 1 || x > n || y < 1 || y > n) return
        if (map[y][x] == 1) return
        if (currentState == 대각선 && (map[y-1][x] == 1 || map[y][x-1] == 1)) return

        if (y == n && x == n){
            answer ++
            return
        }
        when(currentState){
            가로 -> {
                dfs(y, x+1, 가로)
                dfs(y+1, x+1, 대각선)
            }
            세로 -> {
                dfs(y + 1, x, 세로)
                dfs(y+1, x+1, 대각선)
            }
            대각선 -> {
                dfs(y, x+1, 가로)
                dfs(y + 1, x, 세로)
                dfs(y+1, x+1, 대각선)
            }
        }
    }
    dfs(1, 2, 가로)
    println(answer
    )

}