package Any
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val f = Array(n+1){0}
    var countFib = 0
    fun fib(n: Int): Int{

        if (n == 1 || n == 2)
            return 1
        else
            return (fib(n-1) + fib(n-2))
    }
    fun fibonacci(n: Int): Int{

        f[1] = 1
        f[2] = 1
        for (index in 3..n){
            countFib += 1
            f[index] = f[index-1] + f[index-2]
        }
        return f[n]
    }

    fibonacci(n)
    println(fib(n))
    println(countFib)
}