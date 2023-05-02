package first_tenth.Firstday

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    fun fib(num: Int): Int {
        if (num == 0)
            return 0
        if (num == 1)
            return 1
        return fib(num - 1) + fib(num - 2)
    }
    println(fib(n))
}