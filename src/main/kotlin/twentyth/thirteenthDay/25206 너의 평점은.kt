package twentyth.thirteenthDay

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sum = 0.0
    var sum1 = 0.0
    repeat(20){
        val (a,b,c) = br.readLine().split(' ')
        val be = b.toDouble()
        sum += be
        if (c == "A+")
            sum1 += be.toDouble() * 4.5
        else if (c == "A0")
            sum1 += be.toDouble() * 4.0
        else if (c == "B+")
            sum1 += be * 3.5
        else if (c == "B0")
            sum1 += be * 3.0
        else if (c == "C+")
            sum1 += be * 2.5
        else if (c=="C0")
            sum1 += be * 2.0
        else if (c=="D+")
            sum1 += be*1.5
        else if (c=="D0")
            sum1 += be* 1.0
        else if (c=="F")
            sum1 += be* 0.0
        else{
            sum -= be
        }
    }
    println(sum1 / sum)

}