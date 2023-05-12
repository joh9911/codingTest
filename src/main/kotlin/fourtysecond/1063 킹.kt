// 30분 걸림
package fourtysecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (king, stone, n) = br.readLine().split(' ')
    val map = mutableMapOf<Char,Int>()
    var num = 8
    for (index in 'A'..'H'){
        map[index] = num
        num--
    }
    var kingLoc = Pair(9 - king[1].toString().toInt(), map[king[0]]!!)
    var stoneLoc = Pair(9 - stone[1].toString().toInt(), map[stone[0]]!!)
    repeat(n.toInt()){
        when (br.readLine()){
            "R" -> {
                val x = kingLoc.second - 1
                val y = kingLoc.first
                val sX = stoneLoc.second
                val sY = stoneLoc.first
                if (x in 1..8 && y in 1..8){
                    if (x == sX && y == sY){
                        if (sX - 1 in 1..8){
                            kingLoc = Pair(y,x)
                            stoneLoc = Pair(sY,sX - 1)
                        }
                    }
                    else{
                        kingLoc = Pair(y,x)
                    }
                }
            }
            "L" -> {
                val x = kingLoc.second + 1
                val y = kingLoc.first
                val sX = stoneLoc.second
                val sY = stoneLoc.first
                if (x in 1..8 && y in 1..8){
                    if (x == sX && y == sY){
                        if (sX + 1 in 1..8){
                            kingLoc = Pair(y,x)
                            stoneLoc = Pair(sY,sX + 1)
                        }
                    }
                    else{
                        kingLoc = Pair(y,x)
                    }
                }
            }
            "B" -> {
                val x = kingLoc.second
                val y = kingLoc.first + 1
                val sX = stoneLoc.second
                val sY = stoneLoc.first
                if (x in 1..8 && y in 1..8){
                    if (x == sX && y == sY){
                        if (sY + 1 in 1..8){
                            kingLoc = Pair(y,x)
                            stoneLoc = Pair(sY + 1,sX)
                        }
                    }
                    else{
                        kingLoc = Pair(y,x)
                    }
                }
            }
            "T" -> {
                val x = kingLoc.second
                val y = kingLoc.first - 1
                val sX = stoneLoc.second
                val sY = stoneLoc.first
                if (x in 1..8 && y in 1..8){
                    if (x == sX && y == sY){
                        if (sY - 1 in 1..8){
                            kingLoc = Pair(y,x)
                            stoneLoc = Pair(sY - 1,sX)
                        }
                    }
                    else{
                        kingLoc = Pair(y,x)
                    }
                }
            }
            "RT" -> {
                val x = kingLoc.second - 1
                val y = kingLoc.first - 1
                val sX = stoneLoc.second
                val sY = stoneLoc.first
                if (x in 1..8 && y in 1..8){
                    if (x == sX && y == sY){
                        if (sX - 1 in 1..8 && sY - 1 in 1..8){
                            kingLoc = Pair(y,x)
                            stoneLoc = Pair(sY - 1,sX - 1)
                        }
                    }
                    else{
                        kingLoc = Pair(y,x)
                    }
                }
            }
            "LT" -> {
                val x = kingLoc.second + 1
                val y = kingLoc.first - 1
                val sX = stoneLoc.second
                val sY = stoneLoc.first
                if (x in 1..8 && y in 1..8){
                    if (x == sX && y == sY){
                        if (sX + 1 in 1..8 && sY - 1 in 1..8){
                            kingLoc = Pair(y,x)
                            stoneLoc = Pair(sY - 1,sX + 1)
                        }
                    }
                    else{
                        kingLoc = Pair(y,x)
                    }
                }
            }
            "RB" -> {
                val x = kingLoc.second - 1
                val y = kingLoc.first + 1
                val sX = stoneLoc.second
                val sY = stoneLoc.first
                if (x in 1..8 && y in 1..8){
                    if (x == sX && y == sY){
                        if (sX - 1 in 1..8 && sY + 1 in 1..8){
                            kingLoc = Pair(y,x)
                            stoneLoc = Pair(sY + 1,sX - 1)
                        }
                    }
                    else{
                        kingLoc = Pair(y,x)
                    }
                }
            }
            "LB" -> {
                val x = kingLoc.second + 1
                val y = kingLoc.first + 1
                val sX = stoneLoc.second
                val sY = stoneLoc.first
                if (x in 1..8 && y in 1..8){
                    if (x == sX && y == sY){
                        if (sX + 1 in 1..8 && sY + 1 in 1..8){
                            kingLoc = Pair(y,x)
                            stoneLoc = Pair(sY + 1,sX + 1)
                        }
                    }
                    else{
                        kingLoc = Pair(y,x)
                    }
                }
            }
        }
    }
    kingLoc = Pair(9 - kingLoc.first, 9 - kingLoc.second)
    stoneLoc = Pair(9 - stoneLoc.first, 9 - stoneLoc.second)

    val map1 = mutableMapOf<Int,String>()
    var num1 = 1
    for (index in 'A'..'H'){
        map1[num1] = index.toString()
        num1++
    }

    println("${map1[kingLoc.second]}${kingLoc.first}")
    println("${map1[stoneLoc.second]}${stoneLoc.first}")



}