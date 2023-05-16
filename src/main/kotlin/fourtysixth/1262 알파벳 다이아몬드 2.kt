// ex) n = 5
//....e....
//...ede...
//..edcde..
//.edcbcde.
//edcbabcde
//.edcbcde.
//..edcde..
//...ede...
//....e....

// 맨 가운데 a의 좌표는, (n-1, n-1)
// 이 때 2행 1열을 출력하고 싶을 때,
// 1. (n - 1) - 2 = 2
// 2. (n - 1) - 1 = 3
// 이 때, 2열 부터, 2*n - 1 - 2열 사이에 있을 때만 문자열이 존재한다.
// 또한 2행 2열일 때 -> 1. (n-1) - 2 = 2
//                    2. (n-1) - 2 = 2
// 해당 문자열은 2 + 2 = 4 -> 'e' 가 된다.
// 도형 모양이 대칭이므로, 해당 규칙이 성립한다.


package fourtysixth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val list = br.readLine().split(' ').map{it.toInt()}
    val n = list.first()
    val r1 = list[1]
    val c1 = list[2]
    val r2 = list[3]
    val c2 = list[4]
    val map = mutableMapOf<Int,Char>()

    // 0 ~ 25 -> 'a' ~ 'z' 저장
    for ((num, char) in ('a'..'z').withIndex()){
        map[num] = char
    }

    // r 좌표와 c 좌표에서 (2*n - 1) 를 나눈 나머지를 구하여
    // 기본 위치를 구할 수 있다.

    for (r in r1..r2){
        // r의 기본 위치
        val indexR = (r % (2*n - 1))
        for (c in c1..c2){
            // c의 기본 위치
            val indexC = (c % (2*n - 1))
            // 1.
            val v = Math.abs((n-1) - indexR)
            // 2.
            val d = Math.abs((n-1) - indexC)
            // 해당 사이의 열만 문자열
            if (indexC in v until 2*n - 1 - v)
                // 더한 값이 26을 넘어갈 수 있으므로 나머지 처리
                bw.write("${map[(d+v) % 26]}")
            else
                bw.write(".")
            }
        bw.write("\n")
        }
    bw.flush()
}
