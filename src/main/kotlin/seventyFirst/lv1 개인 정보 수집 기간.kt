package seventyFirst

class `lv1 개인 정보 수집 기간` {
    class Solution {
        fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
            val todaySplit = today.split('.')
            val todayYear = todaySplit[0].toInt()
            val todayMonth = todaySplit[1].toInt()
            val todayDay = todaySplit[2].toInt()
            val ans = arrayListOf<Int>()

            val termsMap = mutableMapOf<String,Int>()
            for (index in terms.indices){
                val split = terms[index].split(' ')
                termsMap[split.first()] = split.last().toInt()
            }

            for (index in privacies.indices){
                val split = privacies[index].split(' ')
                val daySplit = split.first().split('.')

                var year = daySplit[0].toInt()
                var month = daySplit[1].toInt()
                var day = daySplit[2].toInt()
                val termDay = termsMap[split.last()]!!

                year += termDay / 12
                month += termDay % 12
                if (month > 12){
                    year += 1
                    month -= 12
                }

                if (day == 1){
                    if (month == 1){
                        month = 12
                        year -= 1
                    }
                    else{
                        month -= 1
                    }
                    day = 28
                }
                else{
                    day -= 1
                }
                println(year)
                println(month)
                println(day)
                if (todayYear > year) {
                    ans.add(index + 1)
                    continue
                }
                if (todayYear == year && todayMonth > month){
                    ans.add(index + 1)
                    continue
                }
                if (todayYear == year && todayMonth == month && todayDay > day){
                    ans.add(index + 1)
                    continue
                }

            }
            val arr = IntArray(ans.size)
            for (index in ans.indices)
                arr[index] = ans[index]
            return arr
        }
    }
}