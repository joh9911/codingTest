package sixthDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Pair<Int,Int>>()
    repeat(n){
        val token = StringTokenizer(br.readLine())
        list.add(Pair(token.nextToken().toInt(),token.nextToken().toInt() ))
    }
    val a = list.sortedWith(compareBy({it.second},{it.first}))
}