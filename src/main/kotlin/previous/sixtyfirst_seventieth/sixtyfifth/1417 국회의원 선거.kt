package sixtyfirst_seventieth.sixtyfifth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n - 1){0}
    var first = br.readLine().toInt()
    repeat(n - 1){
        arr[it] = br.readLine().toInt()
    }
    var count = 0
    while(true){
        var idx = 0
        var max = 0
        for (index in arr.indices){
            if (arr[index] > max)
                idx = index
            max = Math.max(arr[index],max)
        }
        if (first > max)
            break
        count ++
        first += 1
        arr[idx] -= 1
    }
    println(count)
}