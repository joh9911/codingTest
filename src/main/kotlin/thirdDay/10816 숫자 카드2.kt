package thirdDay
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val nList = br.readLine().split(' ').map{it.toInt()}
    val nMap = mutableMapOf<Int,Int>()
    nList.forEach{
        nMap[it] = nMap.getOrDefault(it, 0) + 1
    }
    val m = br.readLine().toInt()
    val mList = br.readLine().split(' ').map{it.toInt()}
    mList.forEach{
        bw.write("${nMap.getOrDefault(it, 0)} ")
    }
    bw.flush()
}
// 첨 코든데 시간초과가 남


//package thirdDay
//import java.io.*
//
//fun thirteenthDay.fourteenthDay.main(){
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val n = br.readLine().toInt()
//    val nList = br.readLine().split(' ').map{it.toInt()}
//    val nMap = mutableMapOf<Int,Int>()
//    repeat(n){
//        if (nMap[nList[it]] == null)
//            nMap[nList[it]] = 1
//        else
//            nMap[nList[it]] = nMap[nList[it]]!! + 1
//    }
//    val m = br.readLine().toInt()
//    val mList = br.readLine().split(' ').map{it.toInt()}
//    for (index in mList.indices){
//        if (nMap[mList[index]] == null)
//            print("0 ")
//        else
//            print("${nMap[mList[index]]} ")
//    }
//}
// 리스트가 엄청 길어질 때를 대비해서 forEach로 바꿈
// getOrDefault라는 매소드를 알게됨, 근데 이거는 관계 없지 않나..?
//그래도 시간초과가 뜸

// 고민했느데, 그냥 단순히 bw 문제였음 ㅅㅂ