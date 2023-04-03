package SecondDay
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val xList = arrayListOf<Int>()
    val yList = arrayListOf<Int>()
    repeat(n){
        val (x,y) = br.readLine().split(' ').map{it.toInt()}
        xList.add(x)
        yList.add(y)
    }
    if (n == 1)
        println(0)
    else{
        xList.sort()
        yList.sort()
        val xMax = xList[xList.size - 1]
        val xMin = xList[0]
        val yMax = yList[yList.size - 1]
        val yMin = yList[0]
        println((xMax - xMin) * (yMax - yMin))
    }
}