package now.second_day

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    while(true){
        val input = br.readLine()
        if (input == "."){
            break
        }
        var tag = false
        val queue = ArrayDeque<Char>()
        for (letter in input){
            if (letter == '(' || letter == '['){
                queue.add(letter)
            }else if (letter == ')'){
                if (queue.isNotEmpty() && queue.last() == '('){
                    queue.removeLast()
                }else{
                    println("no")
                    tag = true
                    break
                }
            }else if (letter == ']'){
                if (queue.isNotEmpty() && queue.last() == '['){
                    queue.removeLast()
                }else{
                    println("no")
                    tag = true
                    break
                }
            }
        }
        if (!tag){
            if (queue.isNotEmpty()){
                println("no")
            }else{
                println("yes")
            }
        }
    }
}