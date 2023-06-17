package sixtyfirst_seventieth.sixtythird
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(m){Array(4){0} }
    repeat(n){
        val input = br.readLine()
        for (index in input.indices){
            when(input[index]){
                'A' -> arr[index][0] += 1
                'C' -> arr[index][1] += 1
                'G' -> arr[index][2] += 1
                'T' -> arr[index][3] += 1
            }
        }
    }
    var count = 0
    for (i in arr.indices){
        val max = arr[i].max()
        for (j in arr[i].indices){
            if (arr[i][j] == max){
                when(j){
                    0 -> print("A")
                    1 -> print("C")
                    2 -> print("G")
                    3 -> print("T")
                }
                break
            }
        }
        count += arr[i].sum() - max
    }
    println()
    println(count)

}