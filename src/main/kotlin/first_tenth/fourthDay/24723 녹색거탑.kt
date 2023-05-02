package first_tenth.fourthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var answer = 1
    repeat(n){
        answer *= 2
    }
    println(answer)
}
//2 4 8 16