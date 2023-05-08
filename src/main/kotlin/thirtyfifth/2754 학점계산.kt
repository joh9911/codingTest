package thirtyfifth
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val input = br.readLine()
    var num = 0.0
    when(input.first()){
        'A' -> num += 4
        'B' -> num += 3
        'C' -> num += 2
        'D' -> num += 1
        'F' -> num = 0.0
    }
    if (input.length == 2){
        when(input.last()){
            '+' -> num += 0.3
            '-' -> num -= 0.3
            '0' -> num += 0.0
        }
    }

    println(num)


}