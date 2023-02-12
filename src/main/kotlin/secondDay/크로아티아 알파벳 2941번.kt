package secondDay
import java.io.*
fun main(){
    val mp = mutableMapOf<String,String>()
    mp["c="] = "č"
    mp["c-"] = "ć"
    mp["dz="] = "dž"
    mp["d-"] = "d-"
    mp["lj"] = "lj"
    mp["nj"] = "nj"
    mp["s="] = "š"
    mp["z="] = "ž"
    val br = BufferedReader(InputStreamReader(System.`in`))
    var word = br.readLine() //입력 받은 문자열
    var count = 0 // count
    var tag = -1 // 문자를 하나하나씩 검사할 거임
    for (index in word.indices){ // 한 단어씩 이동
        var ch = ""
        if (index <= tag){ //검사한 문자열까지 index를 설정하기 위해 만든 조건문
            continue
        }
        for (index1 in index until word.length){ // 한 단어에서 게속해서 string 붙힘
            ch += word[index1]
            if (mp.keys.contains(ch)){ //붙힌 문자열이 key에 포함되었을 경우
                count += 1 // 횟수 증가
                tag = index1 // 그 인덱스에 태그 설정
                break
            }
            if (index1 == word.length-1){ // 계속해서 문자열을 붙혀도 key에 없는 경우 알파벳 하나로 침
                count++
            }
        }
    }
    println(count)
}