// 6 : 22
package fourtyseventh
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val saveList = Array(s.length){'-'}
    val reverseList = Array(s.length){'-'}
    val stack = LinkedList<Char>()

    var string = ""
    for (index in s.indices){
        if (s[index] == '<'){
            stack.add(s[index])
            saveList[index] = s[index]
        }
        else if (s[index] == '>'){
            saveList[index] = s[index]
            stack.removeFirst()
        }
        else if (s[index] == ' '){
            if (stack.isEmpty()){
                reverseList[index] = '-'
                saveList[index] = '+'
            }
            else
                saveList[index] = ' '
        }
        else{
            if (stack.isEmpty())
                reverseList[index] = s[index]
            else
                saveList[index] = s[index]
        }
    }
    var upIdx = 0
    val tempList = arrayListOf<Char>()
    while(true){
        if (upIdx > s.length - 1)
            break

        if (saveList[upIdx] == '+'){
            if (tempList.isNotEmpty()){
                tempList.reversed().forEach{print(it)}
                tempList.clear()
            }
            print(' ')
            upIdx++
            continue
        }
        else if (saveList[upIdx] == '-'){
            tempList.add(reverseList[upIdx])
            upIdx++
        }
        else{
            if (tempList.isNotEmpty()){
                tempList.reversed().forEach{print(it)}
                tempList.clear()
            }
            print(saveList[upIdx])
            upIdx++
        }

    }
    if (tempList.isNotEmpty())
        tempList.reversed().forEach{print(it)}
    println()
    saveList.forEach{print(it)}
    println()
    reverseList.forEach{print(it)}

}
