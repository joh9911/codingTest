package fiftyfirst_sixtieth.fiftyfourth
// 10:55
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    data class Game(
            val number: String,
            val strike: Int,
            val ball: Int
    )

    val gameArr = Array(n){Game("",0,0)}

    repeat(n) {
        val (number, strike, ball) = br.readLine().split(' ').map { it.toInt() }
        gameArr[it] = Game(number.toString(),strike,ball)
    }

    val ans = Array(3){0}
    val visit = Array(10){false}


    fun check(arr: Array<Int>): Boolean{
        for (index in gameArr.indices){
            val game = gameArr[index]
            var number = game.number

            var sCount = 0
            for (i in arr.indices){
                if (arr[i] == number[i].toString().toInt())
                    sCount++
            }
            if (sCount != game.strike)
                return false

            var bCount = 0
            for (i in arr.indices){
                if (arr[i] == number[(i+1)%3].toString().toInt())
                    bCount ++
                if (arr[i] == number[(i+2)%3].toString().toInt())
                    bCount ++
            }
            if (bCount != game.ball)
                return false
        }
        return true
    }
    var ansCount = 0

    fun search(num: Int){
        if (num == 3){
            if (check(ans))
                ansCount ++
            return
        }
        for (index in 1..9){
            if (!visit[index]){
                visit[index] = true
                ans[num] = index
                search(num+1)
                visit[index] = false
            }
        }
    }
    search(0)
    println(ansCount)

}