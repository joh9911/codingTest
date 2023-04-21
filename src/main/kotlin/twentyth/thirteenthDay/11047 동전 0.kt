package twentyth.thirteenthDay

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val list = arrayListOf<Int>()
    repeat(n){
        list.add(br.readLine().toInt())
    }
    var num = k
    var count = 0
    for (index in list.size - 1 downTo 0){
        if (list[index] > num)
            continue
        else{
            while (num >= list[index]){
                num -= list[index]
                count++
            }
        }
    }
    println(count)
}