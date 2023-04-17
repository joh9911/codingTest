package seventeenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val s = br.readLine()
    val q = br.readLine().toInt() // count, index
    val arr = Array(26){IntArray(s.length+1) }
    arr[s[0].code-97][0] = 1
    for (index in 1 until s.length){
        val num = s[index].code - 97
        for (index1 in 0 until 26) {
            arr[index1][index] = arr[index1][index - 1]
        }
        arr[num][index] ++
    }

    repeat(q){
        val (a,b,c) = br.readLine().split(' ')
        val first = b.toInt()
        val last = c.toInt()
        val num = a.first().code-97
        if (first == 0)
            bw.write("${arr[num][last]}\n")
        else
            bw.write("${arr[num][last] - arr[num][first - 1]}\n")
    }
    bw.flush()
}
