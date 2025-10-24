package sixtyfirst_seventieth.sixtynineth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var x = br.readLine()
    var count = 0
    if (x.length == 1){
        println(0)
        val num = x.toInt()
        if (num == 3 || num == 6 || num == 9)
            println("YES")
        else
            println("NO")
    }
    else{
        while(true){
            count += 1
            var num = 0
            for (index in x.indices){
                num += x[index].toString().toInt()
            }
            x = num.toString()
            if (x.length == 1)
                break
        }
        val num = x.toInt()
        println(count)
        if (num == 3 || num == 6 || num == 9)
            println("YES")
        else
            println("NO")
    }

}