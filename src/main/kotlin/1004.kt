import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    repeat(T){
        val (x1, y1, x2, y2) = br.readLine().split(' ').map { it.toInt() }
        val n = br.readLine().toInt()
        var answer = 0
        repeat(n){
            val (x, y, r) = br.readLine().split(' ').map { it.toInt() }
            val distance1 = sqrt((x1 - x).toDouble().pow(2) + (y1 - y).toDouble().pow(2))
            val distance2 = sqrt((x2 - x).toDouble().pow(2) + (y2 - y).toDouble().pow(2))

            if (r > distance1 && r > distance2){

            }
            else if (r < distance1 && r < distance2){

            }
            else{
                answer ++
            }
        }
        println(answer)

    }
}