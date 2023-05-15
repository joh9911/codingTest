package fourtysixth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = br.readLine().split(' ').map{it.toInt()}
    val n = list.first()
    val r1 = list[1]
    val c1 = list[2]
    val r2 = list[3]
    val c2 = list[4]
    val map = mutableMapOf<Int,Char>()
    map[0] = 'z'
    var num = 1
    for (char in 'a'..'y'){
        map[num] = char
        num ++
    }

    val tempArr = Array(2*n){' '}
    for (index in n downTo 1){
        tempArr[n - index + 1] = map[index % 26]!!

    }
    for (index in 2..n){
        tempArr[n + index - 1] = map[index % 26]!!
    }

    val wholeArr = Array(2*n){Array(2*n){" "}}

    for (i in 1 until n){
        var startIdx = 1
        var endIdx = 2*n - 1
        var stIdx = 1
        var etIdx = 2*n - 1
        while(startIdx <= endIdx){
            if (startIdx in n - i+ 1 until n + i){
                wholeArr[i][startIdx] = tempArr[stIdx].toString()
                wholeArr[i][endIdx] = tempArr[etIdx].toString()
                stIdx++
                etIdx--
            }
            else{
                wholeArr[i][startIdx] = "."
                wholeArr[i][endIdx] = "."
            }
            startIdx ++
            endIdx --
        }
    }

    for (i in 1 .. n){
        var startIdx = 1
        var endIdx = 2*n - 1
        var stIdx = 1
        var etIdx = 2*n - 1
        while(startIdx <= endIdx){
            if (startIdx in i .. 2*n - i){
                wholeArr[i+n-1][startIdx] = tempArr[stIdx].toString()
                wholeArr[i+n-1][endIdx] = tempArr[etIdx].toString()
                stIdx++
                etIdx--
            }
            else{
                wholeArr[i+n-1][startIdx] = "."
                wholeArr[i+n-1][endIdx] = "."
            }
            startIdx ++
            endIdx --
        }
    }
//    val arr = Array(200){Array(200){""} }
//    var wholeArrY = 1
//    for (i in arr.indices){
//        if (wholeArrY > 2*n - 1)
//            wholeArrY = 1
//        var wholeArrX = 1
//        for (j in arr[i].indices){
//            if (wholeArrX > 2*n - 1)
//                wholeArrX = 1
//            arr[i][j] = wholeArr[wholeArrY][wholeArrX]
//            wholeArrX++
//        }
//        wholeArrY ++
//    }

//    for (index in wholeArr.indices){
//        for (index1 in wholeArr[index].indices){
//            print("${wholeArr[index][index1]} ")
//        }
//        println()
//    }
    var startR = r1 % (2*n - 1) + 1
    var startC = c1 % (2*n - 1) + 1

    for (index in r1..r2){
        if (startR > 2*n - 1)
            startR = 1
        for (index1 in c1..c2){
            if (startC > 2*n - 1)
                startC = 1
            print(wholeArr[startR][startC])
            startC++
        }
        startC = c1 % (2*n - 1) + 1
        startR++
        println()
    }
}
// 1시간 반