package fifthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()
    var array = Array(count){Array(count){0} }
    repeat(count){
        val (w, h) = br.readLine().split(' ').map{i -> i.toInt()}
        array[0][it] = w
        array[1][it] = h
    }
    println(array[0].max())
    println(array[1].max())
    var width = array[0].max()+10 - array[0].min()
    var height = array[1].max()+10 - array[1].min()

}