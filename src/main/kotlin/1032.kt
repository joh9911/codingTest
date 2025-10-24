import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val array = mutableListOf<String>()
    repeat(n){
        array.add(br.readLine())
    }
    val count = array.size
    val length = array.first().length
    var prevWord = ' '
    val answer = Array(length){' '}
    for (i in 0 until length){
        for (j in 0 until count){
            if (j == 0){
                prevWord = array[j][i]
            }
            else{
                val currentWord = array[j][i]
                if (prevWord != currentWord){
                    answer[i] = '?'
                    break
                }
            }
        }
        if (answer[i] != '?'){
            answer[i] = prevWord
        }
    }
    answer.forEach {
        print(it)
    }
}