package thirtyfirst_fourtieth.thirtySecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val list = br.readLine().split(' ').map{it.toInt()}
    var num = list.max()
    while(true){
        num --
        var sum = 0
        for (index in list.indices){
            if (list[index] <= num)
                continue
            else
                sum += list[index] - num
        }
        if (sum == m){
            println(num)
            break
        }
    }
}