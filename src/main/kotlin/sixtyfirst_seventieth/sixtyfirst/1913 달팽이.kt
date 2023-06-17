package sixtyfirst_seventieth.sixtyfirst
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val loc = br.readLine().toInt()
    val arr = Array(n){Array(n){0} }
    val oddArr = arrayListOf<Int>()
    for (index in 3..999){
        if (index % 2 != 0)
            oddArr.add(index)
    }
    var x = n / 2
    var y = n / 2
    arr[y][x] = 1
    var num = 2

    fun firstUp(){
        y -= 1
        arr[y][x] = num
        num += 1
    }
    fun moveRight(oddNum: Int){
        val idx = oddNum - 2
        for (index in 0 until idx){
            x += 1
            arr[y][x] = num
            num += 1
        }
    }
    fun moveDown(oddNum: Int){
        val idx = oddNum - 1
        for (index in 0 until idx){
            y += 1
            arr[y][x] = num
            num += 1
        }
    }
    fun moveLeft(oddNum: Int){
        val idx = oddNum - 1
        for (index in 0 until idx){
            x -= 1
            arr[y][x] = num
            num += 1
        }
    }
    fun moveUp(oddNum: Int){
        val idx = oddNum - 1
        for (index in 0 until idx){
            y -= 1
            arr[y][x] = num
            num += 1
        }
    }
    for (index in oddArr.indices){
        firstUp()
        moveRight(oddArr[index])
        moveDown(oddArr[index])
        moveLeft(oddArr[index])
        moveUp(oddArr[index])
        if (oddArr[index] == n)
            break
    }
    var xLoc = 0
    var yLoc = 0
    for (i in arr.indices){
        for (j in arr[i].indices){
            if (arr[i][j] == loc){
                xLoc = j + 1
                yLoc = i + 1
            }

            bw.write("${arr[i][j]} ")
        }
        bw.write("\n")
    }
    bw.write("$yLoc $xLoc")
    bw.flush()
}