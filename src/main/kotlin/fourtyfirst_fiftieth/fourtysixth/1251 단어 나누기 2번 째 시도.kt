package fourtyfirst_fiftieth.fourtysixth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val save = arrayListOf<String>()

    for (i in 1 until input.length - 1){
        for (j in i + 1 until input.length){
            val a = input.substring(0 until i).reversed()
            val b = input.substring(i until j).reversed()
            val c = input.substring(j until input.length).reversed()
            var string = a + b + c
            save.add(string)
        }
    }
    save.sort()
    println(save.first())

}