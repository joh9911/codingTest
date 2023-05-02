package twentyFirst_thirtyth.`twenty eighth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n){0}
    for(index in arr.indices){
        arr[index] = index + 1
    }

    repeat(m){
        var (i,j) = br.readLine().split(' ').map{it.toInt()}
        var num = (j - i + 1) / 2
        for (index in 0 until num){
            val temp = arr[i - 1]
            arr[i - 1] = arr[j - 1]
            arr[j - 1] = temp
            i++
            j--
        }

    }
    arr.forEach{print("$it ")}

}