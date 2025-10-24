package one_problem_a_day.july_1st

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.*
import kotlin.math.abs

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    var (n, a, b) = br.readLine().split(" ").map { it.toInt() }

    var round = 0

    while (a != b){
        a = (a + 1) / 2
        b = (b + 1) / 2
        round ++
    }

    println(round)

}