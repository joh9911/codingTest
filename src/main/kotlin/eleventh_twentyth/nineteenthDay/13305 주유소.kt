package eleventh_twentyth.nineteenthDay

import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val length = br.readLine().split(' ').map{it.toLong()}
    val priceList = br.readLine().split(' ').map{it.toLong()}
    var price = 0L
    var position = 0
    var prevPrice = priceList.first()
    while (true){
        if (position == priceList.size - 1)
            break
        if (priceList[position] >= prevPrice){
            price += prevPrice * length[position]
        }
        else{
            price += priceList[position] * length[position]
            prevPrice = priceList[position]
        }
        position++

    }
    bw.write("$price")
    bw.flush()

}
