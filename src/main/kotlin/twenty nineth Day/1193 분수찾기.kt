package `twenty nineth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val x = br.readLine().toInt()
    var sum = 0
    var num = 1
    while(true){
        val prevSum = sum
        sum += num
        if (x in prevSum+1.. sum){
            val v = x - prevSum
            if (num % 2== 0){
                println("${v}/${num - v + 1}")
            }
            else{
                println("${num - v + 1}/$v")
            }
            break
        }
        num++
    }
}