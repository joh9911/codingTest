package fifthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m,n) = br.readLine().split(' ').map{it.toInt()}
    for (index in m..n){
        if (getPrime(index))
            println(index)
    }
}
fun getPrime(n: Int): Boolean {
    if (n==1) return false
    var i = 2
    while (i*i <= n){
        if (n%i++ == 0) return false
    }
    return true
}