package sixtyfirst_seventieth.sixtysixth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m,r) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){Array(m){0} }
    repeat(n){
        val input = br.readLine().split(' ')
        for (index in input.indices){
            arr[it][index] = input[index].toInt()
        }
    }

    fun rotate(num: Int){
        if (num == Math.min(n,m) / 2)
            return
        var startY = num
        var startX = num
        var value = arr[startY][startX]
        for (index in num + 1 until n - num){
            val temp = arr[index][startX]
            arr[index][startX] = value
            value = temp
            startY ++
        }

        for (index in num + 1 until m - num){
            val temp = arr[startY][index]
            arr[startY][index] = value
            value = temp
            startX ++
        }

        for (index in n - 2 - num downTo num){
            val temp = arr[index][startX]
            arr[index][startX] = value
            value = temp
            startY --
        }

        for (index in m - 2 - num downTo num){
            val temp = arr[startY][index]
            arr[startY][index] = value
            value = temp
            startX --
        }
        rotate (num + 1)

    }
    for (index in 0 until r){
        rotate(0)
    }

    for (index in arr.indices){
        for (index1 in arr[index].indices){
            print("${arr[index][index1]} ")
        }
        println()
    }
}