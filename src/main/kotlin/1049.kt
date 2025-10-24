import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    var minA = Int.MAX_VALUE
    var minB = Int.MAX_VALUE
    repeat(m){
        val (a,b) = br.readLine().split(' ').map { it.toInt() }
        minA = Math.min(minA, a)
        minB = Math.min(minB, b)
    }

    val num = (n / 6) + 1
    var answer = Int.MAX_VALUE
    for (index in 0 .. num){
        val a = n - 6 * index
        if (a >= 0){
            val b = a * minB
            answer = Math.min(answer, minA * index + b)
        }
        else{
            answer = Math.min(answer, minA * index)
        }
    }
    println(answer)
}