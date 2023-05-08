package thirtyfourth
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var string = br.readLine()
    val m = br.readLine().toInt()
    var curPosition = string.length
    repeat(m){
        val input = br.readLine()
        if (input.first().toString() == "P"){
            if (curPosition == string.length){
                string += input[2].toString()
                curPosition += 1
            }
            else{
                var temp = ""
                for (index in string.indices){
                    if (index == curPosition)
                        temp += input[2].toString()
                    temp += string[index]
                }
                string = temp
                curPosition += 1
            }
        }
        else if (input.first().toString() == "L"){
            if (curPosition != 0){
                curPosition -= 1
            }
        }
        else if (input.first().toString() == "D"){
            if (curPosition != string.length)
                curPosition += 1
        }
        else{
            if (curPosition != 0){
                var temp = ""
                for (index in string.indices){
                    if (index == curPosition-1)
                        continue
                    temp += string[index]
                }
                string = temp
                curPosition -= 1
            }
        }
//        println(curPosition)
//        println(string)
    }
    println(string)
}