package eleventh_twentyth.eleventhDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    fun fact(num: Long): Long{
        if (num == 1L)
            return 1
        return num * fact(num - 1)
    }
    if (n == 0L)
        println(1)
    else
        println(fact(n))
}