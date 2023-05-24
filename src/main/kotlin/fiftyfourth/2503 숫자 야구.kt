package fiftyfourth
// 10:55
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = arrayListOf<List<Char>>()
    repeat(n){
        val (input, s, b) = br.readLine().split(' ').map{it.toInt()}
        val number = input.toString()
        if (s == 1){
            for (i in 0 until 3){
                val string = Array(3){' '}
                string[i] = number[i]
                if (b == 1){
                    val temp = arrayListOf<Char>()
                    for (j in 0 until 3){
                        if (j == i) continue
                        temp.add(number[j])
                    }
                    var l = 0
                    temp.reverse()
                    println(temp)
                    for (k in 0 until 3){
                        if (string[k] == ' ') {
                            string[k] = temp[l]
                            arr.add(string.toList())
                            string[k] = ' '
                            l++
                        }
                    }
                }
                else if (b == 2){
                    val temp = arrayListOf<Char>()
                    for (j in 0 until 3){
                        if (j == i) continue
                        temp.add(number[j])
                    }
                    var l = 0
                    temp.reverse()
                    for (k in 0 until 3){
                        if (string[k] == ' '){
                            string[k] = temp[l]
                            l++
                        }
                    }
                    arr.add(string.toList())
                }
            }
        }
        else if (s == 2){

        }
    }

}