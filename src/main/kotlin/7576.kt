import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(m){Array(n){0} }


    fun GCD(a: Int, b: Int): Int{
        val r = a % b
        if (r == 0)
            return b
        else
            return GCD(b, r)
    }
}