package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()
    val list = n.map{Character.getNumericValue(it)}
    list.sortedDescending().forEach{print(it)}
}