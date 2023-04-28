package `twenty eighth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = arrayListOf<String>()
    for (index in 0 until n/4){
        list.add("long")
    }
    list.forEach{print("$it ")}
    println("int")
}