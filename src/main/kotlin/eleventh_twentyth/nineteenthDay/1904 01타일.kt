package eleventh_twentyth.nineteenthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n+1){0}
    var count = 0
    while (true){
        count++
        if (count == 1 || count == 2)
            arr[count] = count
        else
            arr[count] = (arr[count - 1] + arr[count - 2]) % 15746
        if (count == n)
            break
    }
    println(arr[count])
}
// 1 1개
// 00 11 2 개
// 100 001 111 3 개
// 1001 1100 0000 0011 1111 5개
// 11001 10011 11100 10000 00001 00100 00111 11111 8개
// 110000 110011 111111 111100 111001 100111 100100 100001 000000 001111 000011 001001 001100  13
