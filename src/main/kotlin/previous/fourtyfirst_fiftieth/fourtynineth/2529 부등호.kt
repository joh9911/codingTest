// 4:50 시작

package fourtyfirst_fiftieth.fourtynineth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val signs = br.readLine().split(' ')

    val ansList = arrayListOf<Long>()

    fun square(num: Int): Long{
        if (num == 0)
            return 1
        var i = 1L
        for (index in 0 until num){
            i *= 10
        }
        return i
    }

    fun dfs(num: Int, ansArr: Array<Int>, visit: Array<Boolean>, prevNum: Int){
        if (num == n + 1){

            var sum = 0L
            for ((i, index) in (ansArr.size - 1 downTo 0).withIndex()){
                sum += (ansArr[index] * square(i))
            }

            ansList.add(sum)
            return
        }
        val sign = signs[num-1]

        for (index in 0 until 10){
            if (!visit[index]){
                if (sign == "<"){
                    if (prevNum < index){
                        visit[index] = true
                        ansArr[num] = index
                        dfs(num+1, ansArr, visit, index)
                        visit[index] = false
                    }

                }
                else{
                    if (prevNum > index){
                        visit[index] = true
                        ansArr[num] = index
                        dfs(num+1, ansArr, visit, index)
                        visit[index] = false
                    }

                }
            }
        }
    }

    for (index in 0 until 10){
        val ansArr = Array(n+1){0}
        val visit = Array(10){false}
        visit[index] = true
        ansArr[0] = index
        dfs(1, ansArr, visit, index)
    }
    val max = ansList.max().toString()
    val min = ansList.min().toString()

    if (max.length < n+1){
        val diff = n+1 - max.length
        for (index in 0 until diff){
            print(0)
        }
        println(max)
    }
    else
        println(max)
    if (min.length < n+1){
        val diff = n+1 - min.length
        for (index in 0 until diff){
            print(0)
        }
        println(min)
    }
    else
        println(min)
}