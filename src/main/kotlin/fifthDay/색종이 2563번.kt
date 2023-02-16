package fifthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()
    var array = Array(100){Array(100){0} }
    repeat(count){
        val (one,two) = br.readLine().split(' ').map{it.toInt()}
        for (index in two until two+10){
            for (index1 in one until one+10){
                array[index][index1] = 1
            }
        }

    }
    var count1 = 0
    for (index in array.indices){
        for (index1 in array[index].indices)
            if (array[index][index1] == 1)
                count1 += 1
    }
    println(count1)
}
