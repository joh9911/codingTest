package thirtyfirst_fourtieth.thirtyfourth
import java.io.*
import java.util.*
//문제 유형을 보고 품
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val t = br.readLine().toInt()
    repeat(t){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        var num = 1L
        for (index in 0 until b){
            num *= a
            num %= 10
        }
        if (num == 0L)
            println(10)
        else
            println(num)
    }
}