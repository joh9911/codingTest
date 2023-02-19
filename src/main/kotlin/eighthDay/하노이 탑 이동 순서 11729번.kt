package eighthDay
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Vector<Vector<Int>>()
    for (index in 0 until n){
        arr[0][index] = index+1
    }
    val count = 0
    func(count, arr)
}
fun func(count: Int, arr: Vector<Vector<Int>>){
    for (index in arr.indices){
        if (arr[index])
    }


}
