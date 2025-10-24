package thirtyfirst_fourtieth.fourtieth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,l) = br.readLine().split(' ').map{it.toInt()}
    val list = br.readLine().split(' ').map{it.toInt()}.sorted()

    var count = 0
    var length = l

    var prevIdx = 0
    var nextIdx = 1

    while(true){
        if (nextIdx >= list.size)
            break
        if (list[nextIdx] - list[prevIdx] + 1 <= l){
            nextIdx ++
        }
        else if (list[nextIdx] - list[prevIdx] + 1 > l){
            prevIdx = nextIdx
            nextIdx ++
            count++
        }
    }
    println(count+1)

}
// 4 3
// 1 2 4 6