package eleventhDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var n: String?

    fun f(array: Array<String>, start: Int, end: Int){
        if (start == end){
            return
        }
        for (index in start until end){
            array[index] = " "
        }
        val size = end - start
        f(array, start - (size/3)*2, start - size/3)
        f(array, end + size/3,end+(size/3)*2)
    }

    while (br.readLine().also{n = it} != null){
        var num = 1
        for (index in 0 until n?.toInt()!!){
            num *= 3
        }
        val arr = Array(num){"-"}
        f(arr,arr.size / 3, (arr.size/3)*2)
        arr.forEach{bw.write(it)}
        bw.write("\n")
    }
    bw.flush()
}