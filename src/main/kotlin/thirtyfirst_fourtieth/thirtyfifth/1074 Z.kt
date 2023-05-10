package thirtyfirst_fourtieth.thirtyfifth
import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, r, c) = br.readLine().split(' ').map { it.toInt() }

    fun calculator(n: Int): Int {
        var num = 1
        for (index in 0 until n) {
            num *= 2
        }
        return num
    }

    fun function(num: Int, prevRNum: Int, prevCNum: Int, startNum: Int, endNum: Int) {
        if (num == 1) {
            var rNum = prevRNum
            var cNum = prevCNum
            if (rNum > 1)
                rNum -= 2
            if (cNum > 1)
                cNum -= 2
//            println(rNum)
//            println(cNum)
//            println(startNum)
//            println(endNum)
            if (rNum == 0){
                if (cNum == 0)
                    println(startNum)
                else
                    println(startNum + 1)
            }
            else{
                if (cNum == 0)
                    println(endNum-1)
                else
                    println(endNum)
            }
            return
        }
        val number = calculator(num)
        val wholeCount = endNum - startNum + 1
        var rNum = prevRNum
        var cNum = prevCNum
        if (rNum > number - 1)
            rNum -= number
        if (cNum > number - 1)
            cNum -= number
//            println(rNum)
//            println(cNum)
//            println(startNum)
//            println(endNum)
        val v = wholeCount / 4

        if (rNum > (number - 1) / 2) {
            if (cNum > (number - 1) / 2) {
                val start = endNum - v + 1
                val end = endNum

                function(num - 1, rNum, cNum, start, end)

            } else {
                val start = endNum - v*2 + 1
                val end = endNum - v

                function(num - 1, rNum, cNum, start, end)

            }
        } else {
            if (cNum > (number - 1) / 2) {
                val start = endNum - v*3 + 1
                val end = endNum - v*2
                function(num - 1, rNum, cNum, start, end)

            } else {
                val start = endNum - v*4 + 1
                val end = endNum - v*3
                function(num - 1, rNum, cNum, start, end)

            }
        }
    } // 64
    val number = calculator(n)
    val whole = number*number
    function(n, r, c, 0, whole - 1)
}

//1024