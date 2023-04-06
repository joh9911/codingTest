package sixthDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    fun fact(n: Int): Double{
        var value = 1.0
        for (index in n downTo 1){
            value *= index
        }
        return value
    }
    repeat(t){
        val (n,m) = br.readLine().split(' ').map{it.toInt()}
        val d = fact(m) / (fact(n) * fact(m-n))
        println(Math.round(d))
    }

}