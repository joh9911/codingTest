package first_tenth.Firstday
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var list = mutableListOf<Pair<Int,Int>>()
    repeat(n){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        list.add(Pair(a,b))
    }
    list.sortWith(compareBy({it.second},{it.first}))
    var time = list[0]
    var count = 1
    for (index in 1 until list.size){
        if (time.second <= list[index].first){
            time = list[index]
            count += 1
        }
    }
    println(count)
//    var count = 0
//    while (true){
//        count += 1
//        val firstValue = list.minBy{it.first + (it.second - it.first)}
//        list.removeIf{it.first < firstValue.second}
//        if (list.isEmpty())
//            break
//    }
//    println(count)
}

//처음에는 처음 숫자 + (나중 숫자 - 처음 숫자) 가 가장 최소인 것을 고르고,
// 배열에서 고른 것의 나중 숫자보다 처음 숫자가 작은 것들을 지우는 식으로 코드를 짯음
// 따라서 지우다가, 다 지우게 되면, break 하는 형식이였음
// 메모리 초과가 뜸. 사실 틀린지도 모르겠음