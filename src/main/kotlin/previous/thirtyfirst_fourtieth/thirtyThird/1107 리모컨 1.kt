package thirtyfirst_fourtieth.thirtyThird
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val list = br.readLine().split(' ')

    fun isNotBroken(num: Int): Boolean{
        val string = num.toString()
        for (index in string.indices){
            if (string[index].toString() in list)
                return false
        }
        return true
    }

    if (n.toString().length >= Math.abs(n-100))
        println(Math.abs(n-100))
    else{

        var downValue = Int.MAX_VALUE
        for (index in n downTo 0){
            if (isNotBroken(index)){
                downValue = index
                break
            }
        }

        var upValue = Int.MAX_VALUE
        for (index in n .. 999999){
            if (isNotBroken(index)){
                upValue = index
                break
            }
        }


        val downMin = Math.abs(n - downValue) + downValue.toString().length
        val upMin = Math.abs(n - upValue) + upValue.toString().length
        println(Math.min(downMin,upMin))
    }
}