package twentyth.nineteenthDay

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val plusList = arrayListOf<String>()
    val minusList = arrayListOf<String>()
    var isMinusCome = false
    for (index in input.indices){
        if (isMinusCome){
            if (input[index].toString() != "+" && input[index].toString() != "-")
                minusList.add(input[index].toString())
            else
                minusList.add(" ")
        }
        else{
            if (input[index].toString() != "+" && input[index].toString() != "-")
                plusList.add(input[index].toString())
            else if (input[index].toString() == "+")
                plusList.add(" ")
            else
                isMinusCome = true
        }
    }

    var plusSum = 0
    var string = ""
    if (plusList.isNotEmpty()){
        for (index in plusList.indices){
            if (plusList[index] == " "){
                plusSum += string.toInt()
                string = ""
            }
            else
                string += plusList[index]
        }
        plusSum += string.toInt()
    }
    var minusSum = 0
    var string1 = ""
    if (minusList.isNotEmpty()){
        for (index in minusList.indices){
            if (minusList[index] == " "){
                minusSum += string1.toInt()
                string1 = ""
            }
            else
                string1 += minusList[index]
        }
        minusSum += string1.toInt()
    }

    println(plusSum - minusSum)
}