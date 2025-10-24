package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(r) { Array(c) { 0 } }
    val waterVisit = Array(r) { Array(c) { false } }
    val animalVisit = Array(r) { Array(c) { false } }

    val dx = arrayOf(1, 0, 0, -1)
    val dy = arrayOf(0, 1, -1, 0)

    val waterStartList = mutableListOf<Pair<Int,Int>>()
    var animalStart = Pair(0, 0)
    // D == -2
    // X == -3
    // W == -1

    for (i in 0 until r) {
        val input = br.readLine()
        for (j in 0 until c) {
            val char = input[j]
            when (char) {
                'X' -> {
                    waterVisit[i][j] = true
                    animalVisit[i][j] = true
                    arr[i][j] = -3
                }

                'D' -> {
                    arr[i][j] = -2
                }

                '*' -> {
                    waterStartList.add(Pair(i, j))
                    arr[i][j] = -1
                }

                'S' -> {
                    animalStart = Pair(i, j)
                    arr[i][j] = 1
                }

                '.' -> {
                    arr[i][j] = 0
                }
            }
        }
    }


    fun bfs(waterStartList: MutableList<Pair<Int, Int>>, animalStart: Pair<Int, Int>): Int {
        var waterQueue = LinkedList<Pair<Int, Int>>()
        var animalQueue = LinkedList<Pair<Int, Int>>()
        for (index in waterStartList.indices){
            waterQueue.add(waterStartList[index])
            waterVisit[waterStartList[index].first][waterStartList[index].second] = true
        }
        animalQueue.add(animalStart)
        animalVisit[animalStart.first][animalStart.second] = true
        var ans = -1
        var animalTag = false
        while (animalQueue.isNotEmpty()) {
            val tempWaterQueue = LinkedList<Pair<Int,Int>>()
            while (waterQueue.isNotEmpty()) {
                val waterPrev = waterQueue.poll()

                for (index in 0 until 4) {
                    val waterNext = Pair(waterPrev.first + dx[index], waterPrev.second + dy[index])

                    if (waterNext.first < 0 || waterNext.first >= r || waterNext.second < 0 || waterNext.second >= c) continue
                    if (waterVisit[waterNext.first][waterNext.second] || arr[waterNext.first][waterNext.second] == -3 || arr[waterNext.first][waterNext.second] == -2 || arr[waterNext.first][waterNext.second] >= 1) continue
                    arr[waterNext.first][waterNext.second] = -1
                    waterVisit[waterNext.first][waterNext.second] = true
                    tempWaterQueue.add(waterNext)
                }
            }
            waterQueue = tempWaterQueue

            val tempAnimalQueue = LinkedList<Pair<Int,Int>>()
            while (animalQueue.isNotEmpty()){
                val animalPrev = animalQueue.poll()
                for (index in 0 until 4) {
                    val animalNext = Pair(animalPrev.first + dx[index], animalPrev.second + dy[index])

                    if (animalNext.first < 0 || animalNext.first >= r || animalNext.second < 0 || animalNext.second >= c) continue
                    if (animalVisit[animalNext.first][animalNext.second] || arr[animalNext.first][animalNext.second] == -1 || arr[animalNext.first][animalNext.second] == -3) continue
                    if (arr[animalNext.first][animalNext.second] == -2) {
                        animalTag = true
                        ans = arr[animalPrev.first][animalPrev.second]
                        break
                    }
                    arr[animalNext.first][animalNext.second] = arr[animalPrev.first][animalPrev.second] + 1
                    animalVisit[animalNext.first][animalNext.second] = true
                    tempAnimalQueue.add(animalNext)
                }
            }
            animalQueue = tempAnimalQueue

            if (animalTag) {
                break
            }
        }
        return ans
    }

    val ans = bfs(waterStartList, animalStart)
    if (ans == -1) {
        println("KAKTUS")
    } else {
        println(ans)

    }
}