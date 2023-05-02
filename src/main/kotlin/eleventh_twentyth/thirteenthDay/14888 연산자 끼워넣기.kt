package eleventh_twentyth.thirteenthDay
import java.io.*


// 입력에서 0번째는 +, 1번째는 -, 2번째는 *, 3번째는 / 이므로
// map에 key는 index로, value는 개수로 저장을 했음
// dfs 함수 내에서 0~3 까지 for문을 돌려서,
// 해당하는 map의 value 값이 0이 되는 것만 값을 넣어주도록 했음


fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    val list1 = br.readLine().split(' ').map{it.toInt()}
    val visitMap = mutableMapOf<Int,Int>()
    // 연산자를 저장할 배열
    val arr = Array(n-1){0}
    // 나올 수 있는 경우의 수를 저장할 배열
    val ans = arrayListOf<Int>()
    // map에 추가
    for (index in list1.indices){
        visitMap[index] = list1[index]
    }

    // value는 0~3 중 하나, start end는 각각 연산을 해줄 값
    fun cal(value: Int,start: Int,end:Int): Int{
        return when (value) {
            0 -> start + end
            1 -> start - end
            2 -> start * end
            3 -> start / end
            else -> 0
        }
    }

    fun dfs(num: Int){
        if (num==n - 1){
            var sum = 0
            //값을 더하여 ans 배열에 저장
            for (index in arr.indices){
                if (index == 0)
                    sum = cal(arr[index],list[index], list[1])
                else
                    sum = cal(arr[index], sum, list[index + 1])
            }
            ans.add(sum)
            return
        }
        // 반복문을 돌려 map의 value값이 0보다 큰 것만 배열에 저장
        for (index in list1.indices){
            if (visitMap[index]!! > 0){
                visitMap[index] = visitMap[index]!! - 1
                arr[num] = index
                dfs(num+1)
                visitMap[index] = visitMap[index]!! + 1
            }
        }
    }

    dfs(0)
    println(ans.max())
    println(ans.min())

}