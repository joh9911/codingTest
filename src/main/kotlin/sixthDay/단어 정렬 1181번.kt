package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val count = br.readLine().toInt()
    val list = mutableListOf<String>()
    repeat(count){
        list.add(br.readLine())
    }
    val a = list.distinct().sortedWith(compareBy({it.length}, {it}))
    a.forEach{bw.write(it)
    bw.write("\n")}
    bw.flush()
}
// 그냥 sort 하면 사전순으로 정렬이 됨