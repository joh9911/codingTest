package fourtyfirst_fiftieth.fourtyfirst
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(n+1){0}
    for (index in list.indices){
        arr[index+1] = list[index]
    }
    val c = br.readLine().toInt()
    repeat(c){
        val (g, num) = br.readLine().split(' ').map{it.toInt()}
        if (g == 1){
            for (index in 1 until arr.size){
                if (index % num == 0)
                    arr[index] = Math.abs(arr[index] - 1)
            }
        }
        else{
            arr[num] = Math.abs(arr[num] - 1)
            var upIdx = num + 1
            var downIdx = num - 1
            while(true){
                if (upIdx >= arr.size || downIdx < 1)
                    break
                if (arr[upIdx] == arr[downIdx]){
                    arr[upIdx] = Math.abs(arr[upIdx] - 1)
                    arr[downIdx] = Math.abs(arr[downIdx] - 1)
                    upIdx ++
                    downIdx --
                }
                else
                    break
            }
        }
    }
    if (n >= 20){
        var start = 1
        var end = 20
        while (true){
            for (index in start .. end){
                if (index == end)
                    bw.write("${arr[index]}")
                else
                    bw.write("${arr[index]} ")
            }
            bw.write("\n")

            start += 20
            end += 20

            if (n < end){
                for (index in start .. n){
                    if (index == n)
                        bw.write("${arr[index]}")
                    else
                        bw.write("${arr[index]} ")
                }
                break
            }
        }
    }
    else{
        for (index in 1 .. n){
            if (index == n)
                bw.write("${arr[index]}")
            else
                bw.write("${arr[index]} ")
        }
    }


    bw.flush()

}
