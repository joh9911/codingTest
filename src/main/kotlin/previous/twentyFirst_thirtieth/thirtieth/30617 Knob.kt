package twentyFirst_thirtieth.thirtieth

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val t = br.readLine().toInt()
    var leftValue = "0"
    var rightValue = "0"
    var funValue = 0
    for (index in 0 until t){
        val (l, r) = br.readLine().split(' ')
        if (l == leftValue && l != "0")
            funValue ++
        if (r == rightValue && r != "0")
            funValue ++
        if (l == r && l != "0")
            funValue ++
        leftValue = l
        rightValue = r
    }


    bw.write(funValue.toString())
    bw.flush()

}