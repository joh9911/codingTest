package twentyFirst_thirtyth.`twenty fourth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b,c) = br.readLine().split(' ').map{it.toInt()}
    var maxLine = Math.max(a,Math.max(b,c))
    val restTwoLines = a + b + c - maxLine
    while(maxLine >= restTwoLines){
        maxLine -= 1
    }
    println(restTwoLines + maxLine)
}