package thirtyeighth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b,c) = br.readLine().split(' ').map{it.toInt()}
    println(Math.max(a,Math.max(b,c))-Math.min(a,Math.min(b,c)))


}