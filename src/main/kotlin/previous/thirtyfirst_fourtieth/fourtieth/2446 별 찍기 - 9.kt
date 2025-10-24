package thirtyfirst_fourtieth.fourtieth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (index in 0 until n - 1){
        for (i in 0 until n - 1){
            if (i < index)
                print(" ")
            else
                print("*")
        }
        for (j in 0 until n-index){
                print("*")
        }
            println()
    }
    for (index in 0 until n){
        for (i in 0 until n){
            if (i < n-index-1)
                print(" ")
            else
                print("*")
        }
        for (j in 0 until index)
            print("*")
        println()
    }

}