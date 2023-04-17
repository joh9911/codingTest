package seventeenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val list = br.readLine().split(' ')
    val arr = Array(n){0}
    var finalAns = Int.MIN_VALUE
    var sum = 0
    for (index in list.indices){
        sum += list[index].toInt()
        arr[index] = sum
    }
    arr.forEach{print("$it ")}
    println()
    val l  = arrayListOf<Int>()
    if (n == k)
        println(arr[arr.size-1])
    else{
        for (index in k-1 until arr.size){
            var value = 0
            if (index == k-1)
                value = arr[index]
            else
                value = arr[index] - arr[index-k]
//            l.add(value)
            if (finalAns < value)
                finalAns = value
        }
//        println(l)
        println(finalAns)
    }


}// 3 1 -3 -12 -12 -9