package first_tenth.SecondDay
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val array = Array(5){Array(15){' '} }
    repeat(5){
        val string = br.readLine()
        for (index in string.indices){
            array[it][index] = string[index]
        }
    }
    for (index in 0 until 15){
        for (index1 in 0 until 5){
            if (array[index1][index] == ' ')
                continue
            bw.write(array[index1][index].toString())
        }
    }
    bw.flush()
}