package fourtyfirst_fiftieth.fourtythird
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, new, p) = br.readLine().split(' ').map{it.toInt()}
    if (n == 0)
        println(1)
    else {
        val list = br.readLine().split(' ').map{it.toInt()}
        var r = 1
        var s = 1
        for (index in list.indices){
            if (new < list[index]){
                r += 1
                s += 1
            }
            else if (new == list[index])
                s += 1
            else
                break
        }
        if (s > p){
            println(-1)
        }
        else
            println(r)
    }

}