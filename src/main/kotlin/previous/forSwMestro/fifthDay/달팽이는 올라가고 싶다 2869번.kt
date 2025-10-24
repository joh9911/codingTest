package fifthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b,c) = br.readLine().split(' ').map{it.toInt()}
    var height = c-a
    var dayCount = 0
    dayCount += height/(a-b)
    if (height%(a-b) != 0)
        dayCount += 1
    println(dayCount + 1)

}