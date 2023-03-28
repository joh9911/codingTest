package sixthDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableMapOf<Int,Int>()
    repeat(n){
        val num = br.readLine().toInt()
        if (list.contains(num))
            list[num] = list[num]!! + 1
        else
            list[num] = 1
    }
    var sum = 0
    var size = 0
    list.forEach{sum += it.key * it.value
    size += it.value}
    if (String.format("%.0f",(sum.toDouble()/size.toDouble())) == "-0")
        println(0)
    else
        println(String.format("%.0f",(sum.toDouble()/size.toDouble())))

    val mL = mutableListOf<Int>()
    list.forEach{repeat(it.value){_->
        mL.add(it.key)
    } }
    println(mL.sorted()[(mL.size-1)/2])

    val mValue = list.filter{it.value == list.values.max()}.keys.toMutableList()
    if (mValue.size >= 2){
        println(mValue.sorted()[1])
    }
    else
        println(mValue[0])
    println(list.keys.max() - list.keys.min())
}
