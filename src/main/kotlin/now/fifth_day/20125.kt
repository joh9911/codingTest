package now.fifth_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val map = Array(n){Array(n){' '} }
    for (i in 0 until n){
        val input = br.readLine()
        for (j in 0 until n){
            map[i][j] = input[j]
        }
    }

    fun findHeart(): Pair<Int,Int>{
        val dx = arrayOf(1, 0, 0, -1)
        val dy = arrayOf(0, 1, -1, 0)
        for (i in 0 until n){
            for (j in 0 until n){
                val value = map[i][j]
                if (value == '*'){
                    var count = 0
                    for (k in 0 until 4){
                        val moveX = i + dx[k]
                        val moveY = j + dy[k]
                        if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n) continue
                        if (map[moveX][moveY] == '*')
                            count++
                    }
                    if (count == 4)
                        return Pair(i,j)
                }
            }
        }
        return Pair(0,0)
    }

    fun findLeftArmLength(heart: Pair<Int,Int>): Int{
        var count = 0
        var current = heart
        while(true){
            current = Pair(current.first, current.second - 1)
            if (current.first < 0 || current.first >= n || current.second < 0 || current.second >= n) break
            if (map[current.first][current.second] == '*'){
                count++
            }
            else{
                break
            }

        }
        return count
    }

    fun findRightArmLength(heart: Pair<Int,Int>): Int{
        var count = 0
        var current = heart
        while(true){
            current = Pair(current.first, current.second + 1)
            if (current.first < 0 || current.first >= n || current.second < 0 || current.second >= n) break
            if (map[current.first][current.second] == '*'){
                count++
            }
            else{
                break
            }
        }
        return count
    }

    fun findBackLengthAndLocation(heart: Pair<Int,Int>): Triple<Int, Int, Int>{
        var count = 0
        var current = heart
        while(true){
            current = Pair(current.first + 1, current.second)
            if (current.first < 0 || current.first >= n || current.second < 0 || current.second >= n) break
            if (map[current.first][current.second] == '*'){
                count++
            }
            else{
                break
            }
        }
        return Triple(count, current.first - 1, current.second)
    }

    fun findLegLength(start: Pair<Int, Int>): Int{
        var count = 0
        var current = start
        while(true){
            current = Pair(current.first + 1, current.second)
            if (current.first < 0 || current.first >= n || current.second < 0 || current.second >= n) break
            if (map[current.first][current.second] == '*'){
                count++
            }
            else{
                break
            }
        }
        return count + 1
    }

    val heart = findHeart()
    val leftArmLength = findLeftArmLength(heart)
    val rightArmLength = findRightArmLength(heart)
    val backInfo = findBackLengthAndLocation(heart)
    val leftLegLength = findLegLength(Pair(backInfo.second + 1, backInfo.third - 1))
    val rightLegLength = findLegLength(Pair(backInfo.second + 1, backInfo.third + 1))

    println("${heart.first + 1} ${heart.second + 1}")
    println("${leftArmLength} $rightArmLength ${backInfo.first} $leftLegLength $rightLegLength")

}