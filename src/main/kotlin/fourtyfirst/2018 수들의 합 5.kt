package fourtyfirst
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var count = 0
    var prevIdx = 1
    var nextIdx = 1
    var sum = 0
    while(true){
        if (nextIdx > n+1)
            break

        if (sum < n){
            sum += nextIdx
            nextIdx++
        }
        else if (sum == n){
            sum = 0
            count++
            prevIdx ++
            nextIdx = prevIdx
        }
        else{
            sum -= prevIdx
            prevIdx++
        }
    }
    println(count)
}