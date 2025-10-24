package eleventhDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (one,two) = br.readLine().split(' ').map{it.toInt()}

    fun getValue(n: Int): Int {
        var i = 2
        while (i*i <= n){
            if (n%i == 0) return i
            i++
        }
        return n
    }
    var num1 = one
    var num2 = two
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    while (num1 != 1){
        val value = getValue(num1)
        println(value)
        list1.add(value)
        num1 /= value
    }
    while (num2 != 1){
        val value = getValue(num2)
        list2.add(value)
        num2 /= value
    }



}
