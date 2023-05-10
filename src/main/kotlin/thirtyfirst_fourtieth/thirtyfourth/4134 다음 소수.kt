package thirtyfirst_fourtieth.thirtyfourth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val t = br.readLine().toInt()
    fun isPrime(n: Long): Boolean{
        if (n <= 1)
            return false
        var i = 2L
        while (i*i<=n){
            if (n%i++==0L)
                return false
        }
        return true
    }
    repeat(t){
        var n = br.readLine().toLong()

        while(true){
            if (isPrime(n)){
                bw.write("$n\n")
                break
            }
            n++

        }
    }
    bw.flush()
}