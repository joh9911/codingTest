package eleventh_twentieth.nineteenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t){
        val n = br.readLine().toInt()
        val arr = Array(n){0L}
        for (index in 0 until n){
            if (index < 3)
                arr[index] = 1
            else{
                arr[index] = (arr[index-2] + arr[index - 3]).toLong()
            }
        }
        println(arr[n-1])
    }
    // 10 -4 3 1 5 6 -35 12 21 -1
    // 10 6 9 10 15 21 -14 -2 19 18
}