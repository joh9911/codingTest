package thirtyfirst_fourtieth.thirtyThird

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val broken = if (m != 0) {
        br.readLine().split(' ')
    } else {
        listOf()
    }
    fun isNotBroken(num: Int): Boolean{
        val string = num.toString()
        for (index in string.indices){
            if (string[index].toString() in broken)
                return false
        }
        return true
    }

    var minPress = Math.abs(n - 100)

    for (i in 0..999999) {
        if (isNotBroken(i)) {
            val current = i.toString()
            val press = current.length + Math.abs(n - i)
            minPress = minOf(minPress, press)
        }
    }

    println(minPress)
}