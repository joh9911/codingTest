package sixthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val list = mutableSetOf<Int>()
    repeat(n){
        list.add(br.readLine().toInt())
    }
    list.sorted().forEach{bw.write(it.toString())
    bw.write("\n")}
    bw.flush()
}
//sort는 갖다 써도됨
//시간 초과에 출력 문제도 생각!
