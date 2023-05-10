package thirtyfirst_fourtieth.thirtyThird
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    while(true){
        val (a,b,c) = br.readLine().split(' ').map{it.toInt()}
        if (a==0&&b==0&&c==0)
            break
        val max = Math.max(a,Math.max(b,c))
        if (max == a){
            if (a*a == b*b + c*c)
                println("right")
            else
                println("wrong")
        }
        else if (max == b){
            if (b*b == a*a + c*c)
                println("right")
            else
                println("wrong")
        }
        else{
            if (c*c == b*b + a*a)
                println("right")
            else
                println("wrong")
        }
    }
}