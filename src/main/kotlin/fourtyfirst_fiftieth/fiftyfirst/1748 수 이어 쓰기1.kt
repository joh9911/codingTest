package fourtyfirst_fiftieth.fiftyfirst
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    var sum = 0
    fun f(num: Long): Int{
        var number = num
        var i = 1
        while(number > 9){
            number /= 10
            i ++
        }
        return i
    }
    for (index in 1..n){
        sum += f(index)
    }
    println(sum)

}