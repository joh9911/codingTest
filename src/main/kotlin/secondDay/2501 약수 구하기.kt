package SecondDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    var list = arrayListOf<Int>()
    list.add(1)
    fun isPrime(n: Int) {
        var i = 2
        while (i*i <= n){
            if (n%i == 0)
                list.add(i)
            i ++
        }
    }
    isPrime(n)
    println(list)
}