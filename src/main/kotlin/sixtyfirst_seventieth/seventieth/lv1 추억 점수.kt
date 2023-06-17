package sixtyfirst_seventieth.seventieth
class Solution2 {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val yearningMap = mutableMapOf<String,Int>()
        for (index in name.indices){
            yearningMap[name[index]] = yearning[index]
        }
        val answer = IntArray(photo.size)
        for (i in photo.indices){
            var sum = 0
            for (j in photo[i].indices){
                sum += yearningMap.getOrDefault(photo[i][j],0)
            }
            answer[i] = sum
        }
        return answer
    }

}