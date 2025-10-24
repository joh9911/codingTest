package first_tenth.Firstday

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val list = arrayListOf<Int>()
    for (index in 1..n){
        if (n % index == 0)
            list.add(index)
    }
    if (k-1 >= list.size)
        println(0)
    else
        println(list[k-1])
}