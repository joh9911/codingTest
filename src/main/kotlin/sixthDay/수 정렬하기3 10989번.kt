package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val list = mutableMapOf<Int,Int>()
    repeat(n){
        val num = br.readLine().toInt()
        if (list.contains(num))
            list[num] = list[num]!! + 1
        else
            list[num] = 1
    }
    list.keys.sorted().forEach{
        for (index in 0 until list[it]!!){
            bw.write(it.toString())
            bw.write("\n")
        }
    }
    bw.flush()
}