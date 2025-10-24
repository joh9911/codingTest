package fourtyfirst_fiftieth.fourtyfirst
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val aList = br.readLine().split(' ').map{it.toInt()}
    val bList = br.readLine().split(' ').map{it.toInt()}
    val cList = br.readLine().split(' ').map{it.toInt()}
    fun print1(zero: Int){
        if (zero == 1)
            println("A")
        else if (zero == 2)
            println("B")
        else if (zero == 3)
            println("C")
        else if (zero == 4)
            println("D")
        else
            println("E")
    }

    var zero = 0
    for (index in aList.indices){
        if (aList[index] == 0)
            zero += 1
    }
    print1(zero)
    zero = 0

    for (index in bList.indices){
        if (bList[index] == 0)
            zero += 1
    }

    print1(zero)
    zero = 0

    for (index in cList.indices){
        if (cList[index] == 0)
            zero += 1
    }
    print1(zero)
    zero = 0





}
