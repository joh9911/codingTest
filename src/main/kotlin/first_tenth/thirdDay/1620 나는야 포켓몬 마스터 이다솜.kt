package first_tenth.thirdDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val map = mutableMapOf<String,Int>()
    val list = mutableListOf<String>()
    repeat(n){
        val input = br.readLine()
        map[input] = it + 1
        list.add(input)
    }
    repeat(m){
        val input = br.readLine()
        if (map[input] == null)
            println(list[input.toInt() - 1])
        else
            println(map[input])
    }
}

// 첨에는 println(map.filterValues{it == input.toInt()}.keys.first())
// 나중에는 그냥 리스트 만들어줌