package fourtyfirst
import java.io.*
import java.math.BigInteger

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val aList = br.readLine().split(' ').map{it.toInt()}.sorted()
    val bList = br.readLine().split(' ').map{it.toInt()}.sortedByDescending{it}
    var sum = 0
    for (index in aList.indices){
        sum += aList[index] * bList[index]
    }
    println(sum)
}
