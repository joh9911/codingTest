package thirdDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCase = br.readLine().toInt()
    val clothesMap = mutableMapOf<String,Int>()
    repeat(testCase){
        val clothesCount = br.readLine().toInt()
        var count = 1
        for (index in 0 until clothesCount){
            val stringToken = br.readLine().split(' ')
            if (clothesMap.containsKey(stringToken[1]))
                clothesMap[stringToken[1]] = 1+clothesMap[stringToken[1]]!!
            else
                clothesMap[stringToken[1]] = 1
        }
        clothesMap.forEach{count *= it.value+1}
        println(count - 1)
        clothesMap.clear()
    }
}