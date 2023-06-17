package seventyFourth

class `lv1 숫자 문자열과 영단어` {
    class Solution {
        fun solution(s: String): Int {
            var answer: Int = 0
            var an = ""
            val map = mutableMapOf<String,Int>()
            val arr = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
            for (index in arr.indices){
                map[arr[index]] = index
            }

            var add = ""
            for (index in s.indices){
                if (s[index].code > 57){
                    add += s[index]
                    val value = map.getOrDefault(add, -1)
                    if (value != -1){
                        add = ""
                        an += value
                    }
                }
                else{
                    add = ""
                    an += s[index]
                }
            }
            answer = an.toInt()
            return answer
        }
    }
}