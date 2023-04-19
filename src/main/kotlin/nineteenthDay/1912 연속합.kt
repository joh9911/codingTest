package nineteenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){0}
    var sum = 0
    for (index in list.indices){
        sum += list[index]
        arr[index] = sum
    }
    var max = Int.MIN_VALUE
    for (index in arr.indices){
        for (index1 in index until arr.size){
            if (index != 0){
                val value = arr[index1] - arr[index-1]
                if (max < value)
                    max = value
            }
            else{
                val value = arr[index1]
                if (max < value)
                    max = value
            }
        }
    }
    arr.forEach{
        print("$it ")
    }
    println()
    println(max)
}// 10 6 9 10 15 21 -14 -2 19 18