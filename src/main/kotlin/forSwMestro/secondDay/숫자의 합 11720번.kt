package secondDay

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine()
    var ans = 0
    for (index in list.indices) {
        ans += list[index].toString().toInt()
    }
    println(ans)
}
// 스트링으로 변환 후 인트 쓰자
// 아니면 Character.getNumericValue()