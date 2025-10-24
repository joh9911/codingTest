package one_problem_a_day.july_1st

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.*
import kotlin.math.abs

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t){

        val n = br.readLine().toInt()
        val arr = Array(n + 2){Pair(0,0)}
        arr[0] = Pair(1, 0)
        arr[1] = Pair(0, 1)
        if (n >= 2){
            for (index in 2 .. n){
                val pair = Pair(arr[index - 1].first + arr[index - 2].first, arr[index-1].second + arr[index - 2].second)
                arr[index] = pair
            }
        }
        println("${arr[n].first} ${arr[n].second}")

    }


}
// 규칙을 파악해보자
// N = 1 일 때 1은 1번 출력된다.
// N = 2 일 때 1은 1번, 0은 1번 출력된다.
// N = 3 일 때 1은 2번, 0은 1번 출력된다.
// N = 4 일 때 1은 3번, 0은 2번 출력된다.
// N = 5 일 때 1은