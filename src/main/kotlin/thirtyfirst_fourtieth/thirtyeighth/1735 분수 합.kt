package thirtyfirst_fourtieth.thirtyeighth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b) = br.readLine().split(' ').map{it.toInt()}
    val (c,d) = br.readLine().split(' ').map{it.toInt()}

    fun gcd(a: Int,b:Int): Int{
        return if (b==0) a
        else gcd(b,a%b)
    }
    val p = b*d
    val cb = c*b
    val ad = a*d
    val s = ad+cb
    val e = gcd((s),p)
    println("${s/e} ${p/e}")
}