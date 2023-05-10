package eleventh_twentieth.nineteenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = Array(21){Array(21){Array(21){0} } }
    fun w(a: Int, b: Int, c: Int): Int {
        if (a<=0 || b<=0 || c<=0)
            return 1
        if (a>20 || b> 20 || c>20)
            return w(20, 20, 20)
        if (arr[a][b][c] != 0)
            return arr[a][b][c]
        if (b in (a + 1) until c){
            arr[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1)-w(a,b-1,c)
            return arr[a][b][c]
        }
        arr[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1)
        return arr[a][b][c]
    }
    while(true){
        val (a,b,c) = br.readLine().split(' ').map{it.toInt()}
        if (a == -1 && b== -1 && c== -1)
            break
        println("w($a, $b, $c) = ${w(a,b,c)}")
    }
}