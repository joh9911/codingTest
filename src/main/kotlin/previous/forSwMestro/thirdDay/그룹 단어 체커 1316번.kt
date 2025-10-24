package thirdDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var count = n
    repeat(n){
        val word = br.readLine()  //abcabc
        val list = mutableListOf<Char>() // 반복이 끝난 단어를 저장
        var temp = word[0] //a
        for (index in word.indices){
            if (temp != word[index]){ // 반복 문자가 끝날 때
                list.add(temp) // 리스트에 그 단어를 저장 a b c
                if (list.contains(word[index])){// 이 때 다음 단어가 이 리스트에 포함되어있으면 연속 단어가 아니므로
                    count -=1 // count 1 줄이고
                    break // 반복문 중단
                }
            }
            temp = word[index]
        }
    }
    println(count)
}