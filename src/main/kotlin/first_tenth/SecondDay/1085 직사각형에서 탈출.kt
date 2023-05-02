package first_tenth.SecondDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x,y,w,h) = br.readLine().split(' ').map{it.toInt()}
    val list = arrayListOf<Int>()
    list.add(w-x)
    list.add(h-y)
    list.add(x)
    list.add(y)
    println(list.min())
}