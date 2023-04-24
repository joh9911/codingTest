package twentyfourthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()
    if (a == b && b == c)
        println("Equilateral")
    else if (a + b + c == 180 && (a == b || b == c || a == c))
        println("Isosceles")
    else if (a + b + c == 180)
        println("Scalene")
    else
        println("Error")

}