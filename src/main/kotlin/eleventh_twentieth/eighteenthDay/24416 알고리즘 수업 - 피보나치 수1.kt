package eleventh_twentieth.eighteenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val f = Array(n+1){0}
    var count1 = 0
    fun fi(n: Int): Int{
        if (n == 1 || n == 2){
            count1 ++
            return 1
        }
        else
            return fi(n-1) + fi(n-2)
    }
    fun fibo(n: Int): Int{
        f[1] = 1
        f[2] = 1
        var count = 0
        for (index in 3 .. n){
            count++
            f[index] = f[index - 1] + f[index - 2]
        }
        return count
    }
    fi(n)
    println("$count1 ${fibo(n)}")
}