package firstDay
import java.io.*
import java.text.DecimalFormat
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val c = br.readLine().toInt()
    repeat(c){
        val array = br.readLine().split(' ').map{it.toInt()}.toMutableList()
        val n = array[0]
        array.removeAt(0)
        var count = 0.0
        for (index in 0 until array.size){
            if (array[index] > array.sum()/n){
                count += 1
            }
        }
        println(String.format("%.3f",count/n*100)+"%")
    }
}