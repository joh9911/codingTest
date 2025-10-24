package seventyFourth

class `lv1 신고 결과 받기` {
    class Solution {
        fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
            val reporterArr = Array(id_list.size){mutableSetOf<String>()}
            val idLocationMap = mutableMapOf<String,Int>()
            for (index in id_list.indices){
                idLocationMap[id_list[index]] = index
            }

            val reporterMap = mutableMapOf<String,String>()
            val countMap = mutableMapOf<String,Int>()

            for (index in report.indices){
                val split = report[index].split(' ')
                val reporter = split.first()
                val reported = split.last()
                val reporterIdx = idLocationMap[reporter]!!

                if (reported !in reporterArr[reporterIdx])
                    countMap[reported] = countMap.getOrDefault(reported, 0) + 1


                reporterArr[reporterIdx].add(reported)

            }

            var answer: IntArray = IntArray(id_list.size)
            val reportedList = countMap.filterValues{it >= k}.keys

            for (i in reporterArr.indices){
                var resultCount = 0
                reporterArr[i].forEach{
                    if (it in reportedList)
                        resultCount += 1
                }
                answer[i] = resultCount
            }

            return answer
        }
    }
}