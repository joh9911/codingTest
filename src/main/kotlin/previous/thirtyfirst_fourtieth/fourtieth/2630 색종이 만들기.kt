package thirtyfirst_fourtieth.fourtieth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n+1){Array(n+1){0} }
    var tag = true
    repeat(n){
        val list = br.readLine().split(' ').map{it.toInt()}
        for (index in list.indices){
            arr[it+1][index+1] = list[index]
            if (list[index] == 0)
                tag = false
        }
    }
    var count = 0
    var zCount = 0
    fun function(xStart: Int, xEnd: Int, yStart: Int, yEnd: Int){
        var isZero = false
        var zeroCount = 0
        for (i in yStart ..yEnd){
            for (j in xStart..xEnd){
                if (arr[i][j] == 0){
                    isZero = true
                    zeroCount ++
                }
            }
        }



        val xLen = (xEnd - xStart) + 1
        val yLen = (yEnd - yStart) + 1

        if (zeroCount == xLen*yLen){
            zCount ++

            return
        }

        if (isZero){
            val xMid = (xStart + xEnd) / 2
            val yMid = (yStart + yEnd) / 2
            function(xStart, xMid, yStart, yMid)
            function(xMid+1, xEnd, yStart, yMid)
            function(xStart, xMid, yMid+1, yEnd)
            function(xMid+1, xEnd, yMid+1, yEnd)
        }
        else{
            count++
            return
        }

    }
    if (tag){
        println(0)
        println(1)
    }
    else{
        function(1,n,1,n)
        println(zCount)
        println(count)
    }


}
