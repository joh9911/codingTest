package secondDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val word = br.readLine()
    val array = mutableListOf<Char>()
    for ((count, index) in ('a'..'z').withIndex()){
        array.add(index)
    }
    for (index in array.indices){
        if (word.contains(array[index]))
            print("${word.indexOf(array[index])} ")
        else
            print("-1 ")
    }
}
// for (index in 'a' .. 'z') 이게 되구나
// for for ((count, index) in ('a'..'z').withIndex()){} 이것도 되구나

