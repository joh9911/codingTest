package fifthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var value = 0
    var maxRow = 1
    var maxColumn = 1
    for (index in 1.. 9){
        val inputList = br.readLine().split(' ').map{it.toInt()}
        if (value < inputList.max()){
            value = inputList.max()
            maxRow = inputList.indexOf(value) + 1
            maxColumn = index
        }
    }
    println(value)
    println("$maxColumn $maxRow")
}
// 틀린 이유 maxRow, maxColumn 을 0으로 초기화했음
// 배열이 0으로 가득 차있을 경우 0행 0열을 출력하게 됨
// 한 문제라도 맞으려면 이런거 자세히 읽어보고 조심