package tenth.thirdDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a,b) = br.readLine().split(' ').map{it.toInt()}
    val aMap = mutableMapOf<Int,Int>()
    val bMap = mutableMapOf<Int,Int>()
    val aList = br.readLine().split(' ').map{it.toInt()}
    val bList = br.readLine().split(' ').map{it.toInt()}
    aList.forEach{
        aMap[it] = aMap.getOrDefault(it, 0) + 1
    }
    bList.forEach{
        bMap[it] = bMap.getOrDefault(it, 0) + 1
    }
    aList.forEach{
        bMap[it] = 0
    }
    bList.forEach{
        aMap[it] = 0
    }
    println(aMap.filter{it.value == 1}.size + bMap.filter{it.value == 1}.size)
}