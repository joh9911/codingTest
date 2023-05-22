package fourtyfirst_fiftieth.fourtythird
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = br.readLine()
    val map = mutableMapOf<Char,Int>()

    val ans = Array(list.length){"d"}
    for (index in list.indices){
        map[list[index]] = map.getOrDefault(list[index],0) + 1
    }
    val one = map.filter{it.value % 2 != 0}.keys
    if (one.size >= 2){
        println("I'm Sorry Hansoo")
    }
    else{
        val all = map.filter{it.value >= 1}.keys.sorted()

        var last = ' '
        var setIdx = 0
        var up = 0
        var down = ans.size - 1
        while (up <= down){

            if (up == down){
                if (last == ' '){
                    ans[up] = all[setIdx].toString()
                }
                else
                    ans[up] = last.toString()
                break
            }
            else{
                if (map[all[setIdx]]!! == 1){
                    last = all[setIdx]
                    setIdx++
                    ans[up] = all[setIdx].toString()
                    ans[down] = all[setIdx].toString()
                    map[all[setIdx]] = map[all[setIdx]]!! - 2
                }
                else{
                    ans[up] = all[setIdx].toString()
                    ans[down] = all[setIdx].toString()
                    map[all[setIdx]] = map[all[setIdx]]!! - 2
                }
            }
            if (map[all[setIdx]]!! == 1){
                last = all[setIdx]
                setIdx++
            }
            else if (map[all[setIdx]]!! == 0)
                setIdx++

            up++
            down--
        }
        ans.forEach{
            print(it)
        }
    }
}