package fifthDay
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val list = mutableListOf<Int>()
        for (index in 2..n) {
            if (fun2(index))
                list.add(index)
        }
        val list1 = list.filter{it <= n/2}
        var num1 = 0
        for (index in list1.size-1 downTo 0){
            if (fun2(n - list1[index])){
                num1 = list1[index]
                break
            }
        }
        println("$num1 ${n - num1}")
    }

}
fun fun2(n: Int): Boolean {
    var i = 2
    while (i*i <= n){
        if (n%i++ == 0) return false
    }
    return true
}