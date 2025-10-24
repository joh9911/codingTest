// 2시간 걸림
package fourtyfirst_fiftieth.fourtysecond
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}

    val arr = Array(n){0}

    arr[list.first()] = 1


    for (index in 1 until list.size){
        var count = 0
        var i = 0
        while (true){
            if (count == list[index] && arr[i] == 0)
                break
            if (arr[i] == 0)
                count += 1
            i++
        }
        arr[i] = index + 1
    }
    arr.forEach{
        print("$it ")
    }
}

// 0 2 3 4 0 0 1