package fiftyfirst_sixtieth.fiftyfifth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr1 = Array(n){Array(n){false} }
    val arr2 = Array(n){Array(n){false} }
    repeat(n){
        val input = br.readLine()
        for (index in input.indices){
            if (input[index] == 'X'){
                arr1[it][index] = true
                arr2[it][index] = true
            }

        }
    }
    var aCount = 0
    var bCount = 0

    for (i in arr1.indices){
        for (j in arr1[i].indices){
            var iNum = i
            var iCount = 0
            while(!arr1[iNum][j]){

                arr1[iNum][j] = true
                iNum++
                iCount++
                if (iNum !in 0 until n) break
            }
            if (iCount >= 2)
                bCount += 1

            var jNum = j
            var jCount = 0
            while(!arr2[i][jNum]){
                arr2[i][jNum] = true
                jNum++
                jCount++
                if (jNum !in 0 until n) break
            }
            if (jCount >= 2)
                aCount += 1
        }
    }
    println(aCount)
    println(bCount)
}