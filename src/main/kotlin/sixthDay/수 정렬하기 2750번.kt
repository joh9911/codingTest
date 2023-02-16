package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = arrayListOf<Int>()
    repeat(n){
        list.add(br.readLine().toInt())
    }
    list.sorted().forEach{println(it)}
}