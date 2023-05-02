package eleventh_twentyth.seventeenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val list = br.readLine().split(' ')
    val arr = Array(n){0}
    var sum = 0
    for (index in list.indices){
        sum += list[index].toInt()
        arr[index] = sum
    }// 5 9 12 14 15
    repeat(m){
        val (i,j) = br.readLine().split(' ').map{it.toInt()}
        if (i-1 == 0)
            bw.write("${arr[j-1]}\n")
        else
            bw.write("${arr[j-1] - arr[i-2]}\n")
    }
    bw.flush()
}