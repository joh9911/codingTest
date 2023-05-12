// 10분 걸림
package fourtysecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){Array(m){0} }
    repeat(n){
        val input = br.readLine()
        for (index in input.indices){
            arr[it][index] = input[index].toString().toInt()
        }
    }

    val size = arrayListOf<Int>()
    for (i in arr.indices){
        for (j in arr[i].indices){
            val first = arr[i][j]

            var xStart = j
            var yStart = i

            while (true){
                if (xStart >= m || yStart >= n)
                    break
                val second = arr[i][xStart]
                val third = arr[yStart][j]
                val fourth = arr[yStart][xStart]
                if (first == second && first == third && first == fourth){

                    size.add((xStart - j + 1) * (yStart - i + 1))
                }
                xStart ++
                yStart ++
            }
        }
    }
    println(size.max())

}