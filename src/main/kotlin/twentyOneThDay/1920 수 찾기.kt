package twentyOneThDay

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val listN = br.readLine().split(' ').map{it.toInt()}.sorted()
    val m = br.readLine().toInt()
    val listM = br.readLine().split(' ').map{it.toInt()}
//    println(listN)
    for (index in listM.indices){
        var start = 0
        var end = n-1
        var tag = false
        while(start<=end){
            val mid = (start+end)/2
            if (listN[mid] > listM[index]){
                end = mid - 1
            }
            else if (listN[mid] < listM[index])
                start = mid + 1
            else{
                tag = true
                break
            }
        }
        if (tag)
            println(1)
        else
            println(0)
    }
}//1 2 3 4 5