package secondDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val word = br.readLine().map{
        if (it.code >= 97)
            it.code - 32
        else
            it.code
    }
    val mp = mutableMapOf<Int,Int>()
    val distinctWord = word.distinct()
    for (index in distinctWord.indices){
        mp[distinctWord[index]] = word.count{it == distinctWord[index]}
    }
    if (mp.values.count{it == mp.values.max()} > 1)
        print("?")
    else{
        val w = mp.filterValues{it == mp.values.max()}.keys
        w.forEach{println(it.toChar())}
    }


}
//65~90 대문자
//97~ 122 소문자

//진짜 너무 오래걸렸다.
//map에 대해 무지해서 오래걸린듯
// 먼저 입력 받은 문자열들을 다 아스키코드로 변환했음 ->  다 대문자 아스키 코드로
// 중복을 지우고 map에 각 아스키 코드와 횟수를 key 와 value로 설정
// value의 max 값의 count가 1보다 크면 여러개 있다는 뜻이므로 ? 출력
// value 중에 max 값인 것의 key를 w에 저장
// w는 set이므로 for each로 출력해줌