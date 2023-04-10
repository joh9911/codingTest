package ninethDay

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val stack = LinkedList<Int>()
    val ansStack = LinkedList<Int>()
    val str = arrayListOf<String>()
    val n = br.readLine().toInt()
    repeat(n){
        stack.add(br.readLine().toInt())
    }
    for (index in 1..n){
        if (index <= stack.first){
            ansStack.add(index)
            str.add("+")
        }
        if (ansStack.last >= stack.first){
            while (ansStack.last >= stack.first){
                if (ansStack.last == stack.first)
                    stack.removeFirst()
                ansStack.removeLast()
                str.add("-")
                if (ansStack.isEmpty() || stack.isEmpty())
                    break
            }
        }
    }
    if (stack.isEmpty()){
        str.forEach{println(it)}
    }
    else{
        println("NO")
    }
}
//와 스택에 문자를 넣고 출력하는 방법도 있구나 ㄷㄷ
// 지금은 이전 코드 형태임
//bw.write("+")
//bw.write("\n")
//bw.write("-")
//bw.write("\n")