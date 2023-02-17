package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Pair<Int,Int>>()
    repeat(n){
        val (x,y) = br.readLine().split(' ').map{it.toInt()}
        list.add(Pair(x,y))
    }
    list.sortedWith(compareBy({it.second}, {it.first})).forEach{
        bw.write("${it.first} ${it.second}")
        bw.write("\n")
    }
    bw.flush()
}