package fifthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true){
        val n = br.readLine().toInt()
        if (n == 0) break
        var count = 0
        for (index in n+1 ..n*2){
            if (fun1(index)) count+=1
        }
        println(count)
    }
}
fun fun1(n: Int): Boolean{
    if (n==1) return false
    var i =2
    while (i*i <= n){
        if (n%i++ == 0) return false
    }
    return true
}