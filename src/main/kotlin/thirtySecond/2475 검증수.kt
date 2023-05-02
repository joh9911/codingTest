package thirtySecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = br.readLine().split(' ').map{it.toInt()*it.toInt()}
    println(list.sum() % 10)

}