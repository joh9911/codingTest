package fifthDay
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val m = br.readLine().toInt()
    val n = br.readLine().toInt()
    val mp = arrayListOf<Int>()
    for (index in m..n){
        if (isPrime(index))
            mp.add(index)
    }
    if (mp.isEmpty())
        println(-1)
    else{
        println(mp.sum())
        println(mp.min())
    }


}
fun isPrime(n: Int): Boolean {
    if (n==1)
        return false
    var i = 2
    while (i*i <= n){
        if (n%i++ == 0)
            return false
    }
    return true
}
// 소수를 판별해주는 함수를 외우자 너무 편하네
//fun checkPrime(n: Int): Boolean{
//    if (n == 1) return false
//    var i = 2
//    while (i*i <= n){
//        if (n % i++ == 0) return false
//    }
//    return true
//}