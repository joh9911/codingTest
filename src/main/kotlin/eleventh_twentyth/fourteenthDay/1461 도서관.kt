package eleventh_twentyth.fourteenthDay

import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val list = br.readLine().split(' ').map{it.toInt()}
    val plus = LinkedList<Int>()
    val minus = LinkedList<Int>()
    for (index in list.indices){
        if (list[index] > 0)
            plus.add(list[index])
        else
            minus.add(list[index])
    }
    plus.sort()
    minus.sort()

    var sum1 = 0 // minus 에서 나누어 떨어지지 않을 경우
    if (minus.size % m != 0) {
        val v = minus.size % m // 2
        var last = minus.last()
        for (index in 0 until v) {
            if (index == 0) {
                sum1 = Math.abs(last)
                minus.removeLast()
            } else {
                sum1 += Math.abs(last - minus.last())
                last = minus.removeLast()
            }
        }
        sum1 += Math.abs(last)
    }

    var sum2 = 0 // plus에서 나누어 떨어지지 않을 경우
    if (plus.size % m != 0) {
        val v = plus.size % m
        var first = plus.first()
        for (index in 0 until v) {
            if (index == 0) {
                sum2 = first
                plus.removeFirst()
            } else {
                sum2 += Math.abs(first - plus.first())
                first = plus.removeFirst()
            }
        }
        sum2 += first
    }

    var sum3 = 0
    var i1 = 0
    while (minus.isNotEmpty()){
        i1++
        if (i1 == m){
            sum3 += Math.abs(minus.removeLast()*2)
            i1 = 0
        }
        else
            minus.removeLast()
    }

    var sum4 = 0
    var i2 = 0
    while (plus.isNotEmpty()) {
        i2++
        if (i2 == m) {
            sum4 += plus.removeFirst() * 2
            i2 = 0
        } else
            plus.removeFirst()
    }

    println(sum1 + sum2 + sum3 + sum4 - Math.max(list.max(), Math.abs(list.min())))
}
//    if (Math.abs(plus.last()) >= Math.abs(minus.first()))

//    println(37+2+ 2+2 +11+17+6 +28+1+29) 136
//    println(37+2+ 6+6 +2+9+11 +28+1+29)
//
//    println(4+5+9  +18+8+19+45  +22+18+10)
//    println(1+4+3 +4+1+5 +6+5)


// 1. 전체의 리스트에서 m으로 나누어 떨어지는지, 아닌지 판단   이거 첫 번째 시도. 안해도됨
// 2. 나누어 떨어질 경우, 그대로 정렬하여 계산
// 3.  아닐 경우, plus minus로 나눔
// 4. plus minus 각각 나누어 떨어지는지 판단, 나누어 떨어지지 않을 경우 나머지의 경우만 계산
// 5. 계산한 것을 빼고 다 각각 계산
// 6. 가장 큰 값을 마지막에 빼줌

// 생각해보니, 나누어떨어지는 부분이 잘못됐음. 안해줘도 됐다.
