package twentyFirst_thirtyth.`twenty fourth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    while(true){
        val (a,b,c) = br.readLine().split(' ').map{it.toInt()}
        if (a == 0 && b==0 && c==0)
            break
        val max = Math.max(a,Math.max(b,c))
        if (max >= (a + b + c) - max)
            println("Invalid")
        else{
            if (a==b && b==c)
                println("Equilateral")
            else if (a!=b && b!=c && a!=c)
                println("Scalene")
            else
                println("Isosceles")
        }

    }
}