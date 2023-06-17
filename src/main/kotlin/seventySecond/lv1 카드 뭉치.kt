package seventySecond

class `lv1 카드 뭉치` {
    class Solution {
        fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
            var prevOne = -1
            var prevTwo = -1
            var tag = true
            for (index in goal.indices){
                if (cards1.contains(goal[index])){
                    val idx = cards1.indexOf(goal[index])
                    if (Math.abs(idx - prevOne) != 1){
                        tag = false
                        break
                    }
                    prevOne = idx
                }
                if (cards2.contains(goal[index])){
                    val idx = cards2.indexOf(goal[index])
                    if (Math.abs(idx - prevTwo) != 1){
                        tag = false
                        break
                    }
                    prevTwo = idx
                }
            }
            return if (tag) "Yes" else "No"
        }
    }
}