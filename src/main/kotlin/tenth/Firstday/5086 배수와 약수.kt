package tenth.Firstday

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    fun print(first: Int, second: Int){
        if (second % first == 0)
            println("factor")
        else if (first %  second == 0)
            println("multiple")
        else
            println("neither")
    }
    while (true){
        val (first, second) = br.readLine().split(' ').map{it.toInt()}
        if (first == 0 && second == 0)
            break
        print(first, second)
    }
}