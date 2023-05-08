package thirtyeighth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(1001){0}
    arr[1] = 1
    arr[2] = 3
    arr[3] = 5
    arr[4] = 11
    for (index in 5..1000){
        arr[index] = ((arr[index-2] * 2) % 10007) + (arr[index-1] % 10007)
    }
    println(arr[n]%10007)
}
// 1
// 1

//2
// 3

//3
// 5

//4
// 11

//5
// 21

//6
// 43

