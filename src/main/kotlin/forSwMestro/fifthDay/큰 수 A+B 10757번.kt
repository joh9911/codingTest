package fifthDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (a,b) = br.readLine().split(' ')
    if (a.length > b.length){
        var stringAddition = ""
        repeat(a.length-b.length){
            stringAddition += "0"
        }
        b = stringAddition + b
    }

    if (a.length < b.length){
        var stringAddition = ""
        repeat(b.length - a.length){
            stringAddition += "0"
        }
        a = stringAddition + a
    }
    println(a)
    println(b)
    var point = 0
    var newString= ""
    for (index in a.length-1 downTo 0){
        var plus = Character.getNumericValue(a[index]) + Character.getNumericValue(b[index]) + point
        if (plus >= 10){
            newString = (plus%10).toString() + newString
            point = 1
        }
        else{
            newString = plus.toString() + newString
            point = 0
        }
        if (index == 0){
            if (point != 0)
                newString = point.toString() + newString
        }
    }
    println(newString)

}