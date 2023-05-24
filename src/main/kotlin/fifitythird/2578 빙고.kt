package fifitythird
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = Array(5){Array(5){0} }
    repeat(5){
        val input = br.readLine().split(' ').map{it.toInt()}
        for (index in input.indices){
            arr[it][index] = input[index]
        }
    }
    val ans = Array(5){Array(5){false} }

    fun check(): Int {
        var total = 0
        for (index in 0 until 5){
            var cnt = 0
            for (i in ans[index].indices){
                if (ans[index][i])
                    cnt += 1
            }
            if (cnt == 5)
                total += 1
            cnt = 0
            for (i in ans.indices){
                if (ans[i][index])
                    cnt += 1
            }
            if (cnt == 5)
                total += 1
        }

        var cnt = 0
        for (index in 0 until 5){
            if (ans[index][index])
                cnt += 1
        }
        if (cnt == 5)
            total += 1
        cnt = 0
        for (index in 4 downTo 0){
            if (ans[4 - index][index])
                cnt += 1
        }
        if (cnt == 5)
            total += 1
//        for (index in ans.indices){
//            for (index1 in ans[index].indices){
//                print("${ans[index][index1]} ")
//            }
//            println()
//        }
//        println()
        return total
    }

    var count = 0
    repeat(5){
        val input = br.readLine().split(' ').map{it.toInt()}
        for (index in input.indices){
            for (i in arr.indices){
                for (j in arr.indices){
                    if (arr[i][j] == input[index]){
                        ans[i][j] = true
                        count += 1
                        if (check() >= 3){
                            println(count)
                            System.exit(0)
                        }
                    }
                }
            }
        }
    }
}