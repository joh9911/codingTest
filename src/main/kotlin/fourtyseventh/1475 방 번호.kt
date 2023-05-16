package fourtyseventh
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()

    val map = mutableMapOf<Char,Int>()
    for (char in n){
        map[char] = map.getOrDefault(char,0) + 1
    }
    var one = map.getOrDefault('6',0) + map.getOrDefault('9',0)
    map['6'] = 0
    map['9'] = 0

    if (one % 2 == 0)
        one /= 2
    else
        one = one / 2 + 1

    val two = map.filter{it.value >= 1}.values
    if (two.isEmpty()){
        println(one)
    }
    else{
        if (two.max() >= one)
            println(two.max())
        else
            println(one)
    }



}