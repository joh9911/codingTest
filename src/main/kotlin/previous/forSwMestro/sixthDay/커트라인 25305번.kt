package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val list = br.readLine().split(' ').map{it.toInt()}
    println(list.sortedDescending()[k-1])
}
