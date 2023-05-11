package fourtyfirst
import java.io.*
import java.math.BigInteger

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    fun f(num: Int): BigInteger {
        if (num == 1)
            return 1.toBigInteger()
        else
            return num.toBigInteger() * f(num-1)
    }

    val v = f(n).toString()
    var count = 0
    for (index in v.length-1 downTo 0){
        if (v[index] == '0')
            count++
        else
            break
    }

    println(count)
}