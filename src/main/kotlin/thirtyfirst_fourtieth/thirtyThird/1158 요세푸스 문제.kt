package thirtyfirst_fourtieth.thirtyThird
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){0}
    for (index in 0 until n){
        arr[index] = index + 1
    }
    var t = k - 1
    var count = 0
    var tag = 1
    val list = arrayListOf<Int>()
    list.add(arr[t])
    arr[t] = 0
    while (true){
        if (t > n-1)
            t -= n
        if (arr[t] != 0)
            count++
        if (count == k){
            list.add(arr[t])
            arr[t] = 0
            count = 0
            tag++
        }
        if (tag == n)
            break
        t ++
    }
    print("<")
    for (index in list.indices){
        if (index == list.size - 1)
            print("${list[index]}")
        else
            print("${list[index]}, ")
    }

    print(">")
}