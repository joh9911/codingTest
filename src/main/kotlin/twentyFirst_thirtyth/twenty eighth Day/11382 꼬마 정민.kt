package twentyFirst_thirtyth.`twenty eighth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = br.readLine().split(' ').map{it.toLong()}
    println(list.sum())
}