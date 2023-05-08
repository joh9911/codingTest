package thirtyfourth
import java.io.*
import java.util.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (n,m,b) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n*m){0}
    var start = 0
    repeat(n){
        val token = StringTokenizer(br.readLine())
        for (index in start until m+start){
            arr[index] = token.nextToken().toInt()
        }
        start += m
    }
    val max = arr.max()
    val min = arr.min()
    if (min == max)
        println("0 $min")
    else{
        var minTime = Int.MAX_VALUE
        var minHeight = min
        for (index in min..max){
            var time = 0
            var have = b
            for (index1 in arr.indices){
                if (index > arr[index1]){
                    time += index - arr[index1]
                    have -= index - arr[index1]
                }
                else if (index < arr[index1]){
                    time += (arr[index1]- index)*2
                    have +=  arr[index1] - index
                }
            }
            if (have < 0)
                break

            if (minTime >= time){
                minTime = time
                minHeight = index
            }
        }
        println("$minTime $minHeight")
    }
}
