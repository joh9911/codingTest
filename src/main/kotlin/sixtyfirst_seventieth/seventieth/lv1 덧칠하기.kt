package sixtyfirst_seventieth.seventieth

class `lv1 덧칠하기` {
    class Solution {
        fun solution(n: Int, m: Int, section: IntArray): Int {
            var answer: Int = 1
            var prev = section[0]
            for (index in 1 until section.size){
                if (section[index] - prev >= m){
                    answer += 1
                    prev = section[index]
                }
            }

            return answer
        }
    }
}