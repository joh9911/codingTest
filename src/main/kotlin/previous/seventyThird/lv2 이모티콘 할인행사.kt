package seventyThird

class `lv2 이모티콘 할인행사` {
    class Solution {
        fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {

            // 각 할인의 따른 경우의 수를 저장할 배열
            val pairAns = arrayListOf<Pair<Int,Int>>()

            // dfs를 통해 각 할인의 경우의 수를 선택
            val discounts = arrayListOf(10, 20, 30, 40)
            val ans = Array(emoticons.size){0}

            fun dfs(num: Int){
                if (num == emoticons.size){

                    // 조건에 따라 서비스 가입 수, 구매 비용을 구한 후
                    // Pair 객체 형태로 배열에 저장
                    var totalPrice = 0
                    var totalCount = 0

                    for (i in users.indices){
                        val discount = users[i].first()
                        var price = users[i].last()
                        for (j in ans.indices){
                            if (ans[j] >= discount){
                                price -= emoticons[j] - (emoticons[j] / 100 * ans[j])
                            }
                        }
                        if (price <= 0){
                            totalCount += 1
                        }
                        else{
                            totalPrice += users[i].last() - price
                        }
                    }
                    pairAns.add(Pair(totalCount, totalPrice))
                    return
                }
                for (index in discounts.indices){
                    ans[num] = discounts[index]
                    dfs(num + 1)
                }
            }
            dfs(0)

            // 가입 수, 구매 비용 순으로 정렬
            pairAns.sortWith(compareBy<Pair<Int,Int>>{it.first}.thenBy{it.second})

            // 마지막 원소가 답
            val value = pairAns.last()
            return intArrayOf(value.first, value.second)
        }
    }
}