package secondDay
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var count = 0
    for (index in 1..n){
        if (index == 1000)
            continue
        if (index < 100){
            count += 1
            continue
        }
        if (checker(index))
            count += 1
    }
    println(count)
}
fun checker(n: Int): Boolean {
    var value = n
    var array = mutableListOf<Int>()
    while (value > 9){
        array.add(value%10)
        value /= 10
    }
    array.add(value)
    return array[2] - array[1] == array[1] - array[0]
}

// 1000보다 작거나 같은 수이므로, 100 보다 작은 수는 걍 count 올리고 continue
// 1000인 수는 바로 continue
// 세자리 수일 경우 각 자리수를 배열에 저장 후, 각 자리수 차이가 같은지를 리턴
// 판단해서 count 올리기