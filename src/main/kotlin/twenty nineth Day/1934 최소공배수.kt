package `twenty nineth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        if (a==1 || b==1)
            println(Math.max(a,b))
        else if (a == b)
            println(a)
        else{
            val list = arrayListOf<Int>()
            var num = 2
            while(true){
                if (a % num == 0 && b % num == 0)
                    list.add(num)
                if (num == Math.max(a,b)){
                    list.add(num)
                    break
                }
                num++
            }
            if (list.size == 1)
                println(a*b)
            else
                println(a*b/list[list.size - 2])
        }

    }
}