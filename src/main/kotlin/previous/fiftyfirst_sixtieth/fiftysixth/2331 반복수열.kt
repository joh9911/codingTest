package fiftyfirst_sixtieth.fiftysixth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (num, p) = br.readLine().split(' ').map{it.toInt()}
    val arr = arrayListOf<Int>()
    arr.add(num)

    fun square(num: Int, p: Int): Int{
        var i = 1
        for (index in 0 until p)
            i *= num
        return i
    }
    var idx = 0
    while(true){
        val value = arr.last().toString()
        var sum = 0
        for (index in value.indices){
            sum += square(value[index].toString().toInt(), p)
        }
        if (arr.contains(sum)){
            idx = arr.indexOf(sum)
            break
        }
        arr.add(sum)
    }
    println(idx)
}