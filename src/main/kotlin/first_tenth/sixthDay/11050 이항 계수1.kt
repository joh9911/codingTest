package first_tenth.sixthDay
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    fun fact(n: Int): Int {
        var value = 1
        for (index in n downTo 1){
            value *= index
        }
        return value
    }
    println(fact(n)/ (fact(k) * fact(n - k)))

}
//첫 코드 메모리 초과
//fun factIndex(n: Int, index: Int): Int{
//        if (index == k)
//            return n
//        return n * factIndex(n - 1, index + 1)
//    }
//    fun fact(n: Int): Int {
//        if (n == 1)
//            return 1
//        return n * fact(n - 1)
//    }
//    println(factIndex(n, 1)/ fact(k))

//두 번째 코드 시간초과
//fun factIndex(n: Int): Int{
//    var value = n
//    var temp = n
//    var count = 1
//    while (true){
//        if (count == k)
//            break
//        value *= (temp - 1)
//        temp -= 1
//        count ++
//    }
//    return value
//}
//fun fact(n: Int): Int{
//    var value = n
//    var temp = n
//    while(true){
//        if (temp == 1)
//            break
//        value *= (temp - 1)
//        temp -= 1
//    }
//    return value
//}
//println(factIndex(n)/fact(k))