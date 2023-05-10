package twentyFirst_thirtieth.`twenty eighth Day`
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()

    for (index in 0 until 2*n -1){
        if (index <= n-1){
            for (index1 in 0 .. n-1+index){
                if (index1 in n-1-index..n-1+index)
                    bw.write("*")
                else
                    bw.write(" ")
            }
            bw.write("\n")
        }
        else{
            for (index1 in 0 .. (n-1) + ((2*n-1) - index - 1)){
                if (index1 in index-(n-1)..(n-1) + ((2*n-1) - index - 1))
                    bw.write("*")
                else
                    bw.write(" ")
            }
            bw.write("\n")
        }
    }
    bw.flush()
}
