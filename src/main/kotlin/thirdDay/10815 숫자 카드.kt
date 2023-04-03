package thirdDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    val nMap = mutableMapOf<Int,Int>()
    list.forEach{
        nMap[it] = 1
    }
    val m = br.readLine().toInt()
    val mList = br.readLine().split(' ').map{it.toInt()}
    for (index in mList.indices){
        if (nMap[mList[index]] == 1)
            print("1 ")
        else
            print("0 ")
    }
}