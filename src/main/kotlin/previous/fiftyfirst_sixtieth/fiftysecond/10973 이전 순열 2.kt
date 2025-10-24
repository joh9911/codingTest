package fiftyfirst_sixtieth.fiftysecond
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val input = br.readLine().split(' ').map{it.toInt()}

    var last = input.last()
    val t = arrayListOf<Int>()
    var tag = true
    for (index in input.size - 2 downTo 0){
        if (last < input[index]){
            t.add(last)
            t.sort()
            for (i in 0 until index){
                print("${input[i]} ")
            }
            var value = 0
            for (i in t.size - 1 downTo 0){
                if (t[i] < input[index]){
                    value = t[i]
                    print("$value ")
                    break
                }
            }
            t.add(input[index])
            t.sort()
            for (i in t.size - 1 downTo 0){
                if (t[i] == value)
                    continue
                print("${t[i]} ")
            }

            tag = false
            break
        }
        else{
            t.add(last)
            last = input[index]
        }
    }

    if (tag)
        println(-1)


}