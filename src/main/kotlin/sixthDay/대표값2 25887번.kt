package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = arrayListOf<Int>()
    repeat(5){
        list.add(br.readLine().toInt())
    }
    println(list.sum()/list.size)
    println(list.sorted()[(list.size-1)/2])
}