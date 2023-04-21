package tenth.fourthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val xList = mutableMapOf<Int,Int>()
    val yList = mutableMapOf<Int,Int>()
    repeat(3){
        val (x,y) = br.readLine().split(' ').map{it.toInt()}
        if (xList[x] == null)
            xList[x] = 1
        else
            xList[x] = xList[x]!! + 1
        if (yList[y] == null)
            yList[y] = 1
        else
            yList[y] = yList[y]!! + 1
    }
    println("${xList.filter{it.value == 1}.keys.first()} ${yList.filter{it.value == 1}.keys.first()}")
}

// ㅋㅋㅋㅋㅋ
// xList, yList에 각각 add 한 후,
// for문을 통해 count가 1인 것으로 설정하면 됐음