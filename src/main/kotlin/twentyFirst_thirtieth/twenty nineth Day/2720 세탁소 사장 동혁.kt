package twentyFirst_thirtieth.`twenty nineth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t){
        var c = br.readLine().toInt()
        print("${c/25} ")
        c %= 25
        print("${c / 10} ")
        c %= 10
        print("${c / 5} ")
        c %= 5
        print("${c / 1} ")
        println()
    }
}