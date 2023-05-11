package fourtyfirst
import java.io.*
import java.math.BigInteger

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    val price = br.readLine().toInt()

    var start = 0
    var end = list.max()
    if (list.sum() <= price)
        println(list.max())
    else{
        while (start <= end){
            val mid = (end + start) / 2
            var totalBudget = price
            for (index in list.indices){
                if (list[index] > mid)
                    totalBudget -= mid
                else
                    totalBudget -= list[index]
            }
            if (totalBudget >= 0){
                start = mid + 1
            }
            else
                end = mid - 1

        }
        println(end)
    }

}
