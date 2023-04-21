package tenth.sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    println(list.max() * list.min())
}