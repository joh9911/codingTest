package fourtyseventh
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n+1){Array(m+1){0} }
    repeat(n){
        val list = br.readLine().split(' ')
        for (index in list.indices)
            arr[it+1][index+1] = list[index].toInt()
    }
    val k = br.readLine().toInt()
    repeat(k){
        val (i,j,x,y) = br.readLine().split(' ').map{it.toInt()}
        var sum = 0
        for (index in i..x){
            for (index1 in j..y){
                sum += arr[index][index1]
            }
        }
        println(sum)
    }




}