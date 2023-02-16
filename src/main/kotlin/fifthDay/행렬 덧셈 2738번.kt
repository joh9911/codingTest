package fifthDay
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val a = Array(n){Array(m){0} }
    val b = Array(n){Array(m){0} }
    val result = Array(n){Array(m){0} }
    for (index in a.indices){
        val inputList = br.readLine().split(' ').map{it.toInt()}
        for (index1 in inputList.indices){
            a[index][index1] = inputList[index1]
        }
    }
    for (index in b.indices){
        val inputList = br.readLine().split(' ').map{it.toInt()}
        for (index1 in inputList.indices){
            b[index][index1] = inputList[index1]
        }
    }
    for (index in result.indices){
        for (index1 in result[index].indices){
            print("${a[index][index1] + b[index][index1]} ")
        }
        if (index == result.size - 1)
            break
        println()
    }
}