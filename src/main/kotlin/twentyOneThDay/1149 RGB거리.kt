package twentyOneThDay//import java.io.*
//fun twentyOneThDay.twentythreethDay.main(){
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val n = br.readLine().toInt()
//    val arr = Array(n){Array(3){0} }
//    val dp = Array(n){0}
//    repeat(n){i->
//        val list = br.readLine().split(' ').map{it.toInt()}
//        for (index in list.indices){
//            arr[i][index] = list[index]
//        }
//    }
//    var prevIndex = -1
//
//    for (index in 0 until n){
//        if (index == n - 1){
//            if (prevIndex == 0)
//                dp[index] = Math.min(arr[index][1], arr[index][2])
//            else if (prevIndex == 1)
//                dp[index] = Math.min(arr[index][0], arr[index][2])
//            else
//                dp[index] = Math.min(arr[index][0], arr[index][1])
//        }
//        else{
//            val sum = arr[index].sum()
//            val nextSum = arr[index+1].sum()
//            val min = arr[index].min()
//            val idx = arr[index].indexOf(min)
//            val nextMin = arr[index+1].min()
//            val nextIdx = arr[index+1].indexOf(nextMin)
//            if (sum - min <= nextSum - nextMin){
//                if (index == 0){
//                    if (nextIdx == 0){
//                        val min1 = Math.min(arr[index][1], arr[index][2])
//                        dp[index] = min1
//                        prevIndex = arr[index].indexOf(min1)
//                    }
//                    else if (nextIdx == 1){
//                        val min1 = Math.min(arr[index][0], arr[index][2])
//                        dp[index] = min1
//                        prevIndex = arr[index].indexOf(min1)
//                    }
//                    else{
//                        val min1 = Math.min(arr[index][0], arr[index][1])
//                        dp[index] = min1
//                        prevIndex = arr[index].indexOf(min1)
//                    }
//                }
//                else{
//                    if (prevIndex == nextIdx){
//                        if (nextIdx == 0){
//                            val min1 = Math.min(arr[index][1], arr[index][2])
//                            dp[index] = min1
//                            prevIndex = arr[index].indexOf(min1)
//                        }
//                        else if (nextIdx == 1){
//                            val min1 = Math.min(arr[index][0], arr[index][2])
//                            dp[index] = min1
//                            prevIndex = arr[index].indexOf(min1)
//                        }
//                        else{
//                            val min1 = Math.min(arr[index][0], arr[index][1])
//                            dp[index] = min1
//                            prevIndex = arr[index].indexOf(min1)
//                        }
//                    }
//                    else{
//                        val min1 = sum - arr[index][nextIdx] - arr[index][prevIndex]
//                        dp[index] = min1
//                        prevIndex = arr[index].indexOf(min1)
//                    }
//                }
//            }
//            else{
//                dp[index] = min
//                prevIndex = idx
//            }
//        }
//        println(dp[index])
//    }
//    println(dp.sum())
//}
////197
//// 150
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val rA = Array(n){0} // red의 값
    val gA = Array(n){0} // green의 값
    val bA = Array(n){0} // blue의 값
    val dpR = Array(n){0} // Red을 골랐을 때의 dp 누적 배열
    val dpG = Array(n){0} // Green을 골랐을 때의 dp 누적 배열
    val dpB = Array(n){0} // Blue를 골랐을 때의 dp 누적 배열

    repeat(n){i-> // 각 배열에 입력
        val (r,g,b) = br.readLine().split(' ').map{it.toInt()}
        rA[i] = r
        gA[i] = g
        bA[i] = b
    }
    // 0 번째로는 첫 번째 요소
    dpR[0] = rA[0]
    dpG[0] = gA[0]
    dpB[0] = bA[0]
    // ex) 현재 빨간색을 골랐다면,
    // 이전 것은 파랑, 초록 중 최소를 골라야 한다.
    // 따라서 현재의 빨간색 값 + 최소(파랑, 초록)을 dp 배열에 넣어준다.
    for (index in 1..n-1){
        dpR[index] = Math.min(dpG[index - 1], dpB[index - 1] ) + rA[index]
        dpG[index] = Math.min(dpR[index - 1], dpB[index - 1]) + gA[index]
        dpB[index] = Math.min(dpR[index - 1], dpG[index - 1]) + bA[index]
    }
    // 각 요소의 끝이 최소인 배열을 골라 출력
    println(Math.min(dpR[n-1], Math.min(dpG[n-1], dpB[n-1])))
}