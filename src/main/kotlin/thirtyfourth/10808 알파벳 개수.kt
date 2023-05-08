package thirtyfourth
import java.io.*
import java.util.*
//문제 유형을 보고 품
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val s = br.readLine()
    val map = mutableMapOf<Char,Int>()
    for (index in s.indices){
        map[s[index]] = map.getOrDefault(s[index],0) + 1
    }
    for (index in 'a'..'z'){
        print("${map.getOrDefault(index,0)} ")
    }
}