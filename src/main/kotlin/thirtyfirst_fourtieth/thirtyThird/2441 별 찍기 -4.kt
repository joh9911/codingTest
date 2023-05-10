package thirtyfirst_fourtieth.thirtyThird
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (index in 0 until n){
        for (index1 in 0 until n){
            if (index1 >= index){
                print("*")
            }
            else
                print(" ")
        }
        println()
    }
}