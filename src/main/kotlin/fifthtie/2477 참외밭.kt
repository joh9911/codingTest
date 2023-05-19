// 7 : 18
package fifthtie
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val fruitCnt = br.readLine().toInt()


    val location = arrayListOf<Pair<Int,Int>>()

    repeat(6){
        val input = br.readLine().split(' ').map{it.toInt()}
        val value = Pair(input.first(),input.last())
        location.add(value)
    }

    val locList = arrayListOf<Pair<Int,Int>>()
    val areaList = arrayListOf<Int>()

    var curLoc = Pair(0,0)
    for (index in location.indices){

        val first = location[index]
        val second = if (index+1 > 5)
            location[0]
        else
            location[index+1]

        var target = Pair(0,0)
        when(second.first){
            1 -> target = Pair(curLoc.first + second.second, curLoc.second)
            2 -> target = Pair(curLoc.first - second.second, curLoc.second)
            3 -> target = Pair(curLoc.first, curLoc.second - second.second)
            4 -> target = Pair(curLoc.first, curLoc.second + second.second)
        }
        when(first.first){
            1 -> curLoc = Pair(curLoc.first + first.second, curLoc.second)
            2 -> curLoc = Pair(curLoc.first - first.second, curLoc.second)
            3 -> curLoc = Pair(curLoc.first, curLoc.second - first.second)
            4 -> curLoc = Pair(curLoc.first, curLoc.second + first.second)
        }
        locList.add(target)
        areaList.add(first.second * second.second)
    }
    val areaMax = areaList.max()
    val idx = areaList.indexOf(areaMax)
    val loc = locList[idx]
    for (index in locList.indices){
        if (locList[index] == loc && idx != index){
            println(Math.abs(areaMax - areaList[index]) * fruitCnt)
        }
    }

}
// 1
//2 30
//3 50
//2 50
//3 30
//1 80
//4 80

// 거의 3시간 걸림