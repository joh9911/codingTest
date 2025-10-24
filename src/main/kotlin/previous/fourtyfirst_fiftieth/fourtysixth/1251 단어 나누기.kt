package fourtyfirst_fiftieth.fourtysixth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()

    val save = arrayListOf<Char>()

    val range1 = input.length - 3
    val range2 = input.length - 2
    val range3 = input.length - 1

    var start = 0

    var index1 = 0
    var value = input[start]
    for (i in start + 1 .. range1){
        if (value.code >= input[i].code){
            value = input[i]
            index1 = i
        }
    }

    if (value.code == input[start].code && value.code != 97){
        index1 = start
    }

    for (index in index1 downTo start){
        save.add(input[index])
    }
    start = index1 + 1

    var index2 = 0
    var value2 = input[start]
    for (i in start.. range2){
        if (value2.code >= input[i].code){
            value2 = input[i]
            index2 = i
        }
    }
    if (value2.code == input[start].code && value.code != 97){
        index2 = start
    }

    for (index in index2 downTo start){
        save.add(input[index])
    }

    start = index2 + 1

    for (index in range3 downTo start)
        save.add(input[index])

    save.forEach{print(it)}

}