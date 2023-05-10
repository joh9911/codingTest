package thirtyfirst_fourtieth.thirtyfourth
import java.io.*
import java.util.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val s = Array(21){0}
    for (index in 1..20) s[index] = index
    val empty = Array(21){0}
    var e = Array(21){0}
    repeat(n){
    val input = br.readLine()
        val next = input.split(' ')
        var value: Int = 0
        if (next.size != 1)
            value = next[1].toInt()
        when(next[0]){
            "add" -> e[value] = value
            "check" -> {
                if (e[value] == 0)
                    bw.write("0\n")
                else
                    bw.write("1\n")
            }
            "remove" -> e[value] = 0
            "toggle" -> {
                if (e[value] == 0)
                    e[value] = value
                else
                    e[value] = 0
            }
            "empty" -> {
                e = empty
            }
            "all" -> e = s
        }
    }
    bw.flush()
}