package seventyFirst

class `lv1 대충 만든 자판` {
    class Solution {
        fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
            val map = mutableMapOf<Char,Int>()
            for (i in keymap.indices){
                for (j in keymap[i].indices){
                    map[keymap[i][j]] = Math.min(map.getOrDefault(keymap[i][j], 200), j+1)
                }
            }
            val ans = IntArray(targets.size)
            for (i in targets.indices){
                var sum = 0
                for (j in targets[i].indices){
                    val value = map.getOrDefault(targets[i][j], 0)
                    if (value == 0){
                        ans[i] = -1
                        break
                    }
                    else{
                        sum += value
                    }
                }
                if (ans[i] == 0)
                    ans[i] = sum
            }
            return ans
        }
    }
}