package thirtyfirst_fourtieth.thirtysixth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = br.readLine().split(' ').map{it.toInt()}.sorted()
    list.forEach{print("$it ")}
}