package fifthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val list = mutableListOf<Int>()
    if (n == 1)

    else{
        while (!checkPrime(n)){
            val num = getValue(n)
            list.add(num)
            n /= num
        }
        list.add(n)

        list.forEach{println(it)}
    }

}
fun checkPrime(n: Int): Boolean {
    if (n==1) return false
    var i = 2
    while (i*i <= n){
        if (n%i++ == 0) return false
    }
    return true
}
fun getValue(n: Int): Int{
    var i = 2
    while (i*i <= n){
        if (n%i == 0)return i
        i++
    }
    return 0
}
// 문제 진짜 잘읽기