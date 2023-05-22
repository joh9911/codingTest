// 5분 걸림

package fourtyfirst_fiftieth.fourtysixth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val save = arrayListOf<String>()
    repeat(n){
        save.add(br.readLine())
    }
    var k = 0
    while(true){
        val set = mutableSetOf<String>()
        for (i in save.indices){
            var string = ""
            val number = save[i]
            for (j in number.length-1 downTo number.length-1-k){
                string += number[j]
            }
            set.add(string)
        }
        if (set.size == n){
            break
        }
        k++
    }
    println(k+1)
}