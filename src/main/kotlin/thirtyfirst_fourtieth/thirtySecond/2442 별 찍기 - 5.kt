package thirtyfirst_fourtieth.thirtySecond
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    for (index in 0 until n){
        for (index1 in 0 until n+index){
            if (index1 in n-index-1..n+index-1)
                print("*")
            else{
                print(" ")
            }

        }
        println()
    }
}