package thirdDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var count = 1
    var first = 2

    while (true){
        val last = first+(6*count)
        if (n in first until last){
            break
        }
        first = last
        count++
    }
    if (n == 1)
        println(1)
    else
        println(count+1)
}
//const input = require('fs').readFileSync('/dev/stdin');
//
//let range = 1, block = 1;
//
//while (block < input) {
//  block += 6 * range;
//
//  range++;
//}
//
//console.log(range);
//비교해보기
