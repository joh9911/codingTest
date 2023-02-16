package fifthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tC = br.readLine().toInt()
    repeat(tC){
        val k = br.readLine().toInt()
        val n = br.readLine().toInt()
        val zeroList = Array(k){Array(n){0} }
        for (index in 0 until zeroList[0].size){
            zeroList[0][index] = index+1
        }
        for (index in 1 until k){
            var peopleCount = 0
            for (index1 in 0 until n){
                peopleCount += zeroList[index][index1]
                zeroList[index][index1] = peopleCount
            }
        }
        println(zeroList[0][7])

    }
}

//1 5 14 32
//1 4 9 18 32
//1 3 5 9 14 20 27
//1 2 3 4 5 6 7