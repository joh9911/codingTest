package thirtySecond
import java.io.*
import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    repeat(t){
        val token = StringTokenizer(br.readLine())
        val x1 = token.nextToken().toDouble()
        val y1 = token.nextToken().toDouble()
        val r1 = token.nextToken().toDouble()
        val x2 = token.nextToken().toDouble()
        val y2 = token.nextToken().toDouble()
        val r2 = token.nextToken().toDouble()
        val value = sqrt((x1-x2).pow(2)+(y1-y2).pow(2))
        when{
            value == 0.0 && r1 == r2 -> println(-1)
            value > r1+r2 || value < Math.abs(r1-r2) || (value == 0.0 && r1 != r2) -> println(0)
            value == r1 + r2 || value == Math.abs(r1-r2) -> println(1)
            value < r1+r2 || value > Math.abs(r1-r2) -> println(2)
        }
    }
}