package fiftyfirst_sixtieth.fiftyseventh
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val arr = arrayListOf<String>()

    var start = 0
    var end = 0
    var tag = false
    while(true){
        if (end > input.length - 1){
            val diff = end - start
            if (diff % 2 != 0){
                tag = true
                break
            }
            else{
                val value = diff / 4
                val rest = diff % 4
                for (index in 0 until value * 4)
                    arr.add("A")
                for (index in 0 until rest)
                    arr.add("B")
            }
            break
        }
        if (input[end] == '.'){

            val diff = end - start
            if (diff % 2 != 0){
                tag = true
                break
            }
            else{
                val value = diff / 4
                val rest = diff % 4
                for (index in 0 until value * 4)
                    arr.add("A")
                for (index in 0 until rest)
                    arr.add("B")
            }
            arr.add(".")
            start = end + 1
        }
        end ++
    }
    if (tag)
        println(-1)
    else{
        arr.forEach{
            print(it)
        }
    }

}