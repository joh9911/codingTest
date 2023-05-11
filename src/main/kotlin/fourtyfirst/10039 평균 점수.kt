package fourtyfirst
import java.io.*
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sum = 0
    repeat(5){
        var v = br.readLine().toInt()
        if (v < 40)
            v = 40
        sum += v
    }
    println(sum / 5)
}
