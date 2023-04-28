package `twenty eighth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t){
        val string = br.readLine()
        println("${string.first()}${string.last()}")
    }
}