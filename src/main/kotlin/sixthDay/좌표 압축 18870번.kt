package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    val st = mutableSetOf<Int>()
    for (index in list.indices){
        st.add(list[index])
    }
    val answer = mutableListOf<Int>()
    val mp = mutableMapOf<Int,Int>()
    val disList = list.distinct().sorted()
    for (index in disList.indices){
        mp[disList[index]] = index
    }

    list.forEach{bw.write("${mp[it]} ")}
    bw.flush()
}