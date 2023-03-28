package seventhDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val arr = printStar(n)
    for (index in arr.indices){
        for(index1 in arr[index].indices){
            bw.write(arr[index][index1])
        }
        bw.write("\n")
    }
    bw.flush()
}
fun printStar(n: Int): Array<Array<String>> {
    if (n == 3){
        val arr = Array(3){Array(3){""} }
        for (index in arr.indices){
            for (index1 in arr[index].indices){
                if (index and index1 in n/3 until n-n/3)
                    arr[index][index1] = " "
                else
                    arr[index][index1] = "*"
            }
        }
        return arr
    }
    else{
        val arr = Array(n){Array(n){""} }
        val formerArr = printStar(n/3)
        for (index in arr.indices){
            for (index1 in arr[index].indices){
                if (index in n/3 until n-n/3 && index1 in n/3 until n-n/3){
                    arr[index][index1] = " "
                }

                else{
                    arr[index][index1] = formerArr[index%(n/3)][index1%(n/3)]
                }

            }
        }
        return arr
    }
}