package secondDay
import java.io.*
fun main(){
    val mp = mutableMapOf<String,String>()
    mp["c="] = "č"
    mp["c-"] = "ć"
    mp["dz="] = "dž"
    mp["d-"] = "d-"
    mp["lj"] = "lj"
    mp["nj"] = "nj"
    mp["s="] = "š"
    mp["z="] = "ž"
    val br = BufferedReader(InputStreamReader(System.`in`))
    var word = br.readLine()
    val list = mutableListOf<String>()
    var count = 0
    mp.forEach{ m->
        if(word.contains(m.key)){
            var trash = word.split(m.key)
            println(trash)
            println(trash.size-1)
            println(m.value.count())
            count += (trash.size-1)*(m.value.count())
        }
    }
    println(count)
}