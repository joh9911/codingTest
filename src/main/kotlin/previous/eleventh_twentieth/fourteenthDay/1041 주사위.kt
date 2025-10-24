package eleventh_twentieth.fourteenthDay

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toLong()}
    val a = listOf(list[0], list[5])
    val b = listOf(list[1], list[4])
    val c = listOf(list[2], list[3])
    val d = listOf(a.min(),b.min(),c.min()).sorted()
    val twoSide = d[0] + d[1]
    val threeSide = d.sum()
    if (n == 1){
        println(list.sum() - list.max())
    }

    else{
        val min = list.min()
        val k = n.toLong()
        // 4 * 4 * 4
        // 아래부분
        var num = ((twoSide*4) + (min*(k-2)*4))*(k-1)

        // 윗부분
        var num1 = (threeSide*4 + twoSide*(k-2)*4 + (k-2)*(k-2)*min)

        println(num + num1)

    }
}
//ab ac ad ae bc bd bf ce cf de df ef
//val l2 = listOf(0, 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
//val l22 = listOf(1, 2, 3, 4, 2, 3, 5, 4, 5, 4, 5, 5)
//val l2Value = arrayListOf<Long>()
//for (index in l2.indices){
//    l2Value.add(list[l2[index]] + list[l22[index]])
//}
//    val twoSide = l2Value.min()
// abc abd ace ade fed fbe fbc fce
//val l3 = listOf(0, 0, 0, 0, 5, 5, 5, 5)
//val li3 = listOf(1, 1, 2, 3, 4, 1, 1, 2)
//val lis3 = listOf(2, 3, 4, 4, 3, 4, 2, 4)
//val l3Value = arrayListOf<Long>()
//for (index in l3.indices){
//    l3Value.add(list[l3[index]] +list[li3[index]]+list[lis3[index]] )
//}
//    val threeSide = l3Value.min()

//2 0
//3 1
//4 4
//5 9
//6 16
//7 25
