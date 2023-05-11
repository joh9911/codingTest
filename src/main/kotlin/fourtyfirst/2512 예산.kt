package fourtyfirst
import java.io.*
import java.math.BigInteger

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}.sorted()
    val price = br.readLine().toInt()
    var sum = list.sum()
    if (price >= sum){
        println(list.max())
    }
    else{
        val a = price / n
        var s = 0
        var max = 0
        for (index in list.indices){
            if (list[index] <= a)
                s += a - list[index]
            if (list[index] > a){
                val diff = list.size - index
                if (s % 2 == 0)
                    max = a + s / diff
                else
                    max = a + s / diff + 1
                break
            }
        }
        println(max)
    }
 // 131 / 2
}
// 121
// 11

// 252
// 362
// 483

// 254
// 364
// 121
// 485