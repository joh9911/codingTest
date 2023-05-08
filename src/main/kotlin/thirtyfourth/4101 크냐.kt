package thirtyfourth
import java.io.*
import java.util.*
//문제 유형을 보고 품
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    while(true){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        if (a==0&&b==0)
            break
        if (a > b)
            println("Yes")
        else
            println("No")

    }

}