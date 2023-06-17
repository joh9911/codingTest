package sixtyfirst_seventieth.sixtysecond
import java.io.*
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val k = br.readLine().toInt()
    val arr = Array(k){ArrayList<Int>()}
    repeat(k){
        val token = StringTokenizer(br.readLine())
        val n = token.nextToken().toInt()
        for (index in 0 until n){
            arr[it].add(token.nextToken().toInt())
        }
    }
    for (index in arr.indices){
        println("Class ${index + 1}")
        arr[index].sortByDescending{it}
        var largestGap = 0
        for (i in 1 until arr[index].size){
            largestGap = Math.max(largestGap, Math.abs(arr[index][i] - arr[index][i - 1]))
        }
        println("Max ${arr[index].max()}, Min ${arr[index].min()}, Largest gap ${largestGap}")
    }
}