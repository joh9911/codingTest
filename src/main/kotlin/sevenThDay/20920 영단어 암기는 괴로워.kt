package sevenThDay
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val map = mutableMapOf<String,Int>()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val list = mutableListOf<String>()
    repeat(n) {
        val input = br.readLine()
        if (input.length>=m){
            list.add(input)
            map[input] = map.getOrDefault(input,0) + 1
        }
    }
    val set = list.sortedWith(compareBy<String>
    { -map[it]!! } // 개수
        .thenBy{-it.length} // 길이
        .thenBy{it} // 알파벳
    ).toSet()

    set.forEach{bw.write("${it} ")} // 상관없
    bw.flush()
}
// 귀중한걸 깨달았음
// 처음은 sortedWith에 compareby로 우선순위를 정할 때
// map을 낄 수도 있고.
// thenby로 우선순위를 정할 수도 잇음
// 이 때 나는 map에 map[it]?.time(-1)를 햇음 ㅇ러니 시간초과가 뜸
// -map[it]!! 이렇게 바꿨음 됨
//왠지는 나중에 알아보셈 포스팅할 때