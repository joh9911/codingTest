package thirtyThird
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val list = br.readLine().split(' ').toHashSet()

    fun isNotBroken(num: Int): Boolean{
        val string = num.toString()
        for (index in string.indices){
            if (string[index].toString() in list)
                return false
        }
        return true
    }
    if (m==0)
        println(3)
    if (n.toString().length >= Math.abs(n-100))
        println(Math.abs(n-100))
    else{
        var downValue = n
        var upValue = n
        while (true){
            if (isNotBroken(downValue) && downValue >= 0){
                println(Math.abs(n - downValue) + downValue.toString().length)
                break
            }

            if (isNotBroken(upValue)){
                println(Math.abs(n - upValue) + upValue.toString().length)
                break
            }
            downValue --
            upValue ++
        }
    }
}