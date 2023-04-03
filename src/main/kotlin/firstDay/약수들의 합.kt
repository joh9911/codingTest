package Firstday

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    fun printInCondition(n: Int){
        val list = arrayListOf<Int>()
        for (index in 1.. n){
            if (n % index == 0 && n != index)
                list.add(index)
        }
        if (list.sum() == n){
            print("$n = ")
            for (index in list.indices){
                print("${list[index]}")
                if (index != list.size - 1)
                    print(" + ")
            }
            println()
        }
        else{
            println("$n is NOT perfect.")
        }
    }
    while (true){
        val n = br.readLine().toInt()
        if (n == -1)
            break
        printInCondition(n)
    }
}