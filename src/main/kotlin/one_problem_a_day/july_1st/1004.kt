package one_problem_a_day.july_1st

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.*
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t){
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        val n = br.readLine().toInt()

        var departCount = 0

        var arriveCount = 0

        val arr = Array(n){ listOf(0, 0, 0) }

        for (index in 0 until n){
            arr[index] = br.readLine().split(" ").map { it.toInt() }
        }

        for (index in arr.indices){
            val departDistance = sqrt((x1 - arr[index][0]).toDouble().pow(2) + (y1 - arr[index][1]).toDouble().pow(2))
            val arriveDistance = sqrt((x2 - arr[index][0]).toDouble().pow(2) + (y2 - arr[index][1]).toDouble().pow(2))

            if (departDistance < arr[index][2] && arriveDistance < arr[index][2]){
                continue
            } else{
                if (departDistance < arr[index][2]){
                    departCount ++
                }

                if (arriveDistance < arr[index][2]){
                    arriveCount ++
                }
            }
        }
        println(departCount + arriveCount)
    }
}

// 자 생각을 해보자
// 출발지가 행성 안에 있을 경우: 출발지와 행성 중심간의 거리보다 행성의 반지름의 크기가 더 클 때
// 도착지가 행성 안에 있을 경우: 도착지와 행성 중심간의 거리보다 행성의 만지름의 크기가 더 클 때
// 이 두 개를 더하면 될 것 같다.