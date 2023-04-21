package tenth.thirdDay
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(' ').map{it.toInt()}
    val list = mutableMapOf<Int,Int>()
    for (index in 1..n){
        list[index] = index
    }
    repeat(m){
        val (i, j) = br.readLine().split(' ').map{it.toInt()}
        for (index in j until i){
            
        }
    }
}

