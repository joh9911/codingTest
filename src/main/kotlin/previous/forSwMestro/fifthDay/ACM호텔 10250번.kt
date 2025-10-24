package fifthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCase = br.readLine().toInt()
    repeat(testCase){
        val (h,w,n) = br.readLine().split(' ').map{it.toInt()}
        var floor = 0
        var num = 1
        for (index in 0 until n){
            if (floor == h){
                if (num == w)
                    break
                else{
                    floor = 0
                    num += 1
                }
            }
            floor += 1
        }
        println(floor*100+num)
    }
}