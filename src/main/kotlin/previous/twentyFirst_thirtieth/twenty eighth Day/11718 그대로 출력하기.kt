package twentyFirst_thirtieth.`twenty eighth Day`

import java.io.*


fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var string: String?
    while (br.readLine().also{string = it} != null){
        println(string)
    }
}