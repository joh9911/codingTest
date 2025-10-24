//5:00
package fourtyfirst_fiftieth.fifthtieth
import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val stack = LinkedList<Pair<Char,Int>>()
    val numStack = LinkedList<Pair<Int,Int>>()
    var num = Pair(0,0)
    val arr = arrayListOf<Int>()
    for (index in input.indices){
        if (input[index] == '('){
            stack.add(Pair('(',stack.size))
            numStack.add(Pair(2,stack.size))
        }
        else if (input[index] == '['){
            stack.add(Pair('[',stack.size))
            numStack.add(Pair(3,stack.size))
        }
        else if (input[index] == ')'){
            if (stack.isEmpty() || stack.last().first == '['){
                println(0)
                System.exit(0)
            }
            else{
                if (stack.last().first == '('){
                    stack.removeLast()
                }
                else{
                    println(0)
                    System.exit(0)
                }
            }
        }
        else if (input[index] == ']'){
            if (stack.isEmpty() || stack.last().first == '('){
                println(0)
                System.exit(0)
            }
            else{
                if (stack.last().first == '['){
                    stack.removeLast()
                }
                else{
                    println(0)
                    System.exit(0)
                }
            }
        }
//        println("$index 번째")
//        println(stack)
//        println(numStack)
        if (stack.isEmpty()){
            val a = Array(31){Pair(0,0)}
            num = numStack.removeLast()
            while(numStack.isNotEmpty()){
                println(num)
                val last = numStack.removeLast()
                if (num.second == last.second){
                    num = Pair(num.first+last.first, last.second)
                }
                else if (num.second > last.second)
                    num = Pair(num.first*last.first, last.second)
                else{
                    a[num.second] = num
                    num = last
                    continue
                }

                if (a[num.second].first != 0)
                    num = Pair(num.first + a[num.second].first, num.second)
            }
            arr.add(num.first)
        }
    }
    if (stack.isNotEmpty())
        println(0)
    else
        println(arr.sum())

}