// 6: 50


package fourtyeighth

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n+1){Array(n+1){0} }

    val houseLocation = arrayListOf<Pair<Int,Int>>()
    val chickenLocation = arrayListOf<Pair<Int,Int>>()

    repeat(n){
        val list = br.readLine().split(' ').map{it.toInt()}
        for (index in list.indices){
            if (list[index] == 1)
                houseLocation.add(Pair(it+1, index+1))
            else if (list[index] == 2)
                chickenLocation.add(Pair(it+1, index+1))
            arr[it+1][index+1] = list[index]
        }
    }

    val chooseArr = Array(m){Pair(0,0)}
    val chooseVisit = Array(chickenLocation.size){false}
    val ansArr = arrayListOf<Int>()
    fun dfs1(num: Int, prevIdx: Int){
        if (num == m){
            var sum = 0
            for (index in houseLocation.indices){
                var min = Int.MAX_VALUE
                val x = houseLocation[index].second
                val y = houseLocation[index].first
                for (i in chooseArr.indices){
                    val cx = chooseArr[i].second
                    val cy = chooseArr[i].first
                    val length = Math.abs(cx - x) + Math.abs(cy - y)
                    min = Math.min(length,min)
                }
                sum += min
            }

            ansArr.add(sum)
            return
        }
        for (index in chickenLocation.indices){
            if (!chooseVisit[index]){
                if (prevIdx > index) continue
                chooseVisit[index] = true
                chooseArr[num] = chickenLocation[index]
                dfs1(num+1, index)
                chooseVisit[index] = false
            }
        }
    }
    dfs1(0, -1)
    println(ansArr.min())

}//4,3 5 5