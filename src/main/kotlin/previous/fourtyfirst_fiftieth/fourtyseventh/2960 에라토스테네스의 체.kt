// 5 : 44
package fourtyfirst_fiftieth.fourtyseventh
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val arr = Array(n + 1) { 0 }
    for (index in 2..n) {
        arr[index] = index
    }
    fun isPrime(num: Int): Boolean {
        var i = 2
        while (i * i <= num) {
            if (num % i++ == 0)
                return false
        }
        return true
    }

    var value = 0
    var count = 0
    while (true) {
        var num = 0
        for (index in 2..n) {
            if (arr[index] != 0 && isPrime(arr[index])) {
                num = arr[index]
                break
            }
        }
        var i = num
        while (i <= n) {
            if (arr[i] != 0) {
                arr[i] = 0
                count++
                if (count == k) {
                    value = i
                    break
                }
            }
            i += num
        }
        if (count == k)
            break
        }
        println(value)
    }
