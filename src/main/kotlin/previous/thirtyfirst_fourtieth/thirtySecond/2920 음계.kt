package thirtyfirst_fourtieth.thirtySecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = br.readLine().split(' ').map{it.toInt()}
    var prevNum = list.first()
    var tag = -1
    for (index in 1 until list.size){
        if (Math.abs(prevNum - list[index]) == 1){
            tag = if (prevNum > list[index])
                0
            else
                1
            prevNum = list[index]
        }
        else{
            tag = -1
            println("mixed")
            break
        }
    }
    if (tag == 0)
        println("descending")
    else if (tag == 1)
        println("ascending")

}