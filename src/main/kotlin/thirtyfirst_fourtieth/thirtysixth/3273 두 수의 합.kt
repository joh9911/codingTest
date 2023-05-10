package thirtyfirst_fourtieth.thirtysixth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}.sorted()
    val x = br.readLine().toInt()
//    println(list)
//    println(x)
    var up = 0
    var down = list.size-1
    var count = 0
    while (up < down){
        val first = list[up]
        val second = list[down]
        if (first + second > x)
            down --
        else if (first + second < x)
            up ++
        else{
//            println("$up $down")
            count ++
            up ++
            down --
        }
    }
    println(count)

//    val arr = Array(2){0}
//    val visit = Array(n){false}
//    var count = 0
//    fun dfs(num: Int, prevNum: Int){
//        if (num == 2){
//            if (arr.sum() == x)
//                count++
//            return
//        }
//        for (index in list.indices){
//            if (!visit[index]){
//                if (list[index] <= prevNum)
//                    continue
//                visit[index] = true
//                arr[num] = list[index]
//                dfs(num+1, list[index])
//                visit[index]
//            }
//        }
//    }
//    dfs(0,-1)
//    println(count)
}