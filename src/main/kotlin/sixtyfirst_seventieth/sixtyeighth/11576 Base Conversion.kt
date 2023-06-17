package sixtyfirst_seventieth.sixtyeighth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b) = br.readLine().split(' ').map{it.toInt()}
    val m = br.readLine().toInt()
    val input = br.readLine().split(' ').map{it.toInt()}.reversed()
    var sum = 0

    fun square(num: Int, idx: Int): Int{
        var i = 1
        for (index in 0 until idx)
            i *= num
        return i
    }

    for (index in input.indices){
        sum += input[index] * (square(a, index))
    }

    val ans = arrayListOf<Int>()

    while(sum != 0){
        ans.add(sum % b)
        sum /= b
    }
    ans.reverse()
    for (index in ans.indices){
        print("${ans[index]} ")
    }
}