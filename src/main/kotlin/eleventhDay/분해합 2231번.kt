package eleventhDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = Vector<Int>()
    for (index in n downTo 1){
        if ((index + func1(index)) == n)
            list.add(index)
    }
    if (list.isEmpty())
        println(0)
    else
        println(list.min())


}
fun func1(n: Int): Int {
    var number = n
    var sum = 0
    while (number>9){
        sum += number%10
        number /= 10
    }
    sum += number
    return sum
}
