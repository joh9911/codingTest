package fourtyfirst
import java.io.*
import java.math.BigInteger

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (index in 0 until n - 1){
        for (i in 0 until 2*n){
            if (i <= index || i >= 2*n - index - 1)
                print("*")
            else
                print(" ")
        }
        println()
    }
    for (index in 0 until n){
        for (i in 0 until 2*n){
            if (i <= n - index - 1 || i >= n + index)
                print("*")
            else
                print(" ")
        }
        println()
    }
}
// 10 7