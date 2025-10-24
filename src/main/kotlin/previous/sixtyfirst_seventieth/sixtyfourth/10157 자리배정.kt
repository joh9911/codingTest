package sixtyfirst_seventieth.sixtyfourth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (c,r) = br.readLine().split(' ').map{it.toInt()}
    val k = br.readLine().toInt()
    val arr = Array(r){Array(c){false} }
    var tag = 0
    var x = 0
    var y = r - 1
    if (c*r < k){
        println(0)
    }
    else{
        for (index in 0 until k){
            arr[y][x] = true
            if (index != k - 1){
                when(tag % 4){
                    0 -> {
                        if (y == 0 || arr[y-1][x]){
                            tag += 1
                            x += 1
                        }
                        else{
                            y -= 1
                        }
                    }
                    1 -> {
                        if (x == c - 1 || arr[y][x + 1]){
                            tag += 1
                            y += 1
                        }
                        else
                            x += 1
                    }
                    2 -> {
                        if (y == r - 1 || arr[y+1][x]){
                            tag += 1
                            x -= 1
                        }
                        else
                            y += 1
                    }
                    3 -> {
                        if (x == 0 || arr[y][x - 1]){
                            tag += 1
                            y -= 1
                        }
                        else
                            x -= 1
                    }
                }
            }
        }
        println("${x+1} ${r - y}")
    }

}