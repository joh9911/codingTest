package thirtyfirst_fourtieth.thirtySecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    while(true){
        val n = br.readLine()
        if (n.toInt() == 0)
            break
        var tag = true
        var start = 0
        var end = n.length-1
        while (start <= end){
            if (n[start] != n[end]){
                tag = false
                break
            }
            start ++
            end --
        }
        if (tag)
            println("yes")
        else
            println("no")


    }
}