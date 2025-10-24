package eighthDay
import java.io.*
import java.util.*

fun main() {
    val sb = StringBuilder()
    val n = readLine()!!.toInt()
    var cnt = 0

    fun hanoi(num: Int, start: Int, sub: Int, to: Int){
        if (num == 0) {
            println("리턴")
            return
        }
        cnt += 1
        println("1번째 $num")
        hanoi (num - 1, start, to, sub) // N - 1 개 원반을 시작점 -> sub     1  2  3
        println("2 번째 $num")
        sb.append("$start $to\n") // n번 째 원반 -> 목표 기둥
        hanoi(num - 1, sub, start, to) // N-1 개 원반 sub -> to
    }
    hanoi(n, 1,2,3)
    println(cnt)
    print(sb)
}
// 남의 코드 배낀거임
// 아예 재귀 호출 방식을 제대로 공부해보자
// 풀이 봐도 감이 안온다
