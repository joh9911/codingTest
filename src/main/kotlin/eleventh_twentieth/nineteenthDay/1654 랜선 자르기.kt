package eleventh_twentieth.nineteenthDay

import java.io.*
//fun twentythDay.twentyOneThDay.twentythreethDay.thirtyth.thirtyThird.main(){
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val (k,n) = br.readLine().split(' ').map{it.toInt()}
//    var a = 0
//    if (n % k == 0)
//        a = n / k
//    else
//        a = n / k + 1
//    val arr = Array(n){0}
//    repeat(k){
//        val num = br.readLine().toInt()
//        arr[it] = num
//    } // 6  + 4 + 2
//    val max = arr.max()
//    var v = max / a
//
//    println(v)
//    while(true){ // 6 4 2    2   3 6
//        var j = 0
//        for (index in arr.indices){
//            j += (arr[index] / v)
//        }
//        if (j == n)
//            break
//        v--
//    }
//    println(v)
//} //
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (k,n) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(k){0L}
    repeat(k){
    val num = br.readLine().toLong()
    arr[it] = num
    }
    arr.sort()

    var start = 1L
    var end = arr[k-1].toLong()
    var mid = 0L

    while (start <= end){
        var count = 0L
        mid = (end + start) / 2
        for (index in arr.indices){
            count += arr[index] / mid
        }
        if (count >= n)
            start = mid + 1
        else
            end = mid - 1
    }
    println(end)

}