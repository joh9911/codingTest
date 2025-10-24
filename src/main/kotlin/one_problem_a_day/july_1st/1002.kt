package one_problem_a_day.july_1st

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()

    repeat(t) {
        val arr = br.readLine().split(" ").map { it.toInt() }

        val distance = sqrt((arr[3] - arr[0]).toDouble().pow(2) + (arr[4] - arr[1]).toDouble().pow(2))

        val r1 = arr[2]
        val r2 = arr[5]

        val rDistance = (arr[2] + arr[5]).toDouble()

        val smallR = min(arr[2], arr[5]).toDouble()
        val bigR = max(arr[2], arr[5]).toDouble()

        if (arr[0] == arr[3] && arr[1] == arr[4] && arr[2] == arr[5]){
            println(-1)
        }
        else{
            if (rDistance < distance || (distance + smallR) < bigR) {
                println(0)
            }
            else if (rDistance == distance || (distance + smallR) == bigR){
                println(1)
            }
            else if (rDistance > distance){
                println(2)
            }
        }

    }
}
// 경우의 수를 생각해보자
// 1. 밖에서 아예 안만나는 경우: r1 + r2 값이 둘 사이의 거리보다 작음
// 2. 안에서 아예 안만나는 경우: 둘 사이의 거리 + 작은 r값이 큰 r값 보다 작음
// 3. 밖에서 한 점에서 만나는 경우: r1 + r2 값이 둘 사이의 거리와 같음
// 4. 안에서 한 점에서 만나는 경우: 둘 사이의 거리 + 작은 r값이 큰 r값과 같음
// 5. 두 점에서 만나는 경우: r1 + r2 값이 둘 사이 거리보다 큼
// 6. 무한일 경우: x1, y1 == x2, y2 그리고 r1 == r2 일 때
