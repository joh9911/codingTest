package thirtySecond
import java.io.*
import kotlin.system.exitProcess

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toLong()}
    val list = br.readLine().split(' ').map{it.toLong()}
    var start = 0L
    var end = list.max()
    var value = 0L
    while (start <= end){
        val mid = (end + start)/2.toLong()
        var sum: Long = 0L
        for (index in list.indices){
            if (list[index] < mid)
                continue
            else
                sum += (list[index] - mid).toLong()
        }
        if (sum >= m){
            value = mid
            start = mid + 1
        }
        else
            end = mid - 1
    }
    println(value)
}