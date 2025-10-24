package seventyThird

class `lv2 택배 배달과 수거하기` {
    // 가장 멀리있는 집의 택배를 우선적으로 배달해야 합니다.

// 배달한 후, 현재 들고있는 택배의 양은 0이 되며

// 이 때 배달한 집들 중 가장 멀리있는 집으로 부터 되돌아오며

// 택배를 수거합니다.


    class Solution {
        fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
            // 방문한 집들 중 가장 멀리있는 집의 위치를 저장
            var maxDIdx = 0
            var maxPIdx = 0

            // 들러야할 집들 중 가장 멀리있는 집의 위치를 저장
            var lastDIdx = deliveries.size - 1
            var lastPIdx = deliveries.size - 1

            // 거리를 계산하기 위한 변수
            var point = deliveries.size - 1

            var answer: Long = 0

            while(true){
                // 현재 들고 있는 수용량
                var c = 0

                // 택배를 모두 처리했는지 여부를 확인하는 태그
                var tagD = true
                var tagP = true


                // 멀리있는 집이 우선순위가 가장 크므로

                // 가장 끝에서 부터 반복문을 돌림

                // lastDIdx 는 반복문이 끝나는 곳의 index를 저장
                for (index in lastDIdx downTo 0){
                    if (c == cap)
                        break
                    if (deliveries[index] != 0){
                        tagD = false
                        lastDIdx = index
                        maxDIdx = Math.max(maxDIdx, index)
                        while(c != cap){
                            c += 1
                            deliveries[index] -= 1
                            if (deliveries[index] == 0)
                                break
                        }
                    }
                }

                c = 0
                // lastPx 는 반복문이 끝나는 곳의 index를 저장

                for (index in lastPIdx downTo 0){
                    if (c == cap)
                        break
                    if (pickups[index] != 0){
                        tagP = false
                        lastPIdx = index
                        maxPIdx = Math.max(maxPIdx, index)
                        while (c != cap){
                            c += 1
                            pickups[index] -= 1
                            if (pickups[index] == 0)
                                break
                        }
                    }
                }
                // 만약 모든 택배를 처리했다면 탈출
                if (tagD && tagP)
                    break

                // 들렸던 집들 중 젤 멀리있는 집의 위치 저장
                point = Math.max(maxDIdx, maxPIdx)
                answer += (point + 1) * 2

                maxDIdx = 0
                maxPIdx = 0
            }

            return answer
        }
    }
}