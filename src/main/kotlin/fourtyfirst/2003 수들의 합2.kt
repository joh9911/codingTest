package fourtyfirst
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val list = br.readLine().split(' ').map{it.toInt()}

    var count = 0
    var prevIdx = 0
    var nextIdx = 0
    var sum = 0

    while(true){

        if (sum == m){
            sum = 0
            count ++
            prevIdx = nextIdx
        }

        if (nextIdx >= n)
            break

        if (sum < m){
            sum += list[nextIdx]
            if (sum != m)
                nextIdx++
        }
        if (sum > m){
            sum -= list[prevIdx]
            prevIdx++
            if (sum == m)
                nextIdx--

        }
    }
    println(count)

}
// 10 7