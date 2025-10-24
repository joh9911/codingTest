package seventyFourth
import java.io.*
import java.util.*
class `lv2 두 큐 합 같게 만들기` {

    class Solution {
        fun solution(queue1: IntArray, queue2: IntArray): Int {
            var answer: Int = 0
            val totalSum = queue1.sum().toLong() + queue2.sum().toLong()
            val limit = queue1.size * 4
            if (totalSum % 2 != 0L)
                return -1
            else{

                val queueOne = LinkedList<Int>()
                val queueTwo = LinkedList<Int>()
                queue1.forEach{
                    queueOne.addLast(it)
                }
                queue2.forEach{
                    queueTwo.addLast(it)
                }
                var oneSum = queue1.sum().toLong()
                var twoSum = queue2.sum().toLong()

                while(true){
                    if (oneSum > twoSum){
                        val remove = queueOne.removeFirst()
                        queueTwo.addLast(remove)
                        twoSum += remove
                        oneSum -= remove
                    }
                    else if (oneSum < twoSum){
                        val remove = queueTwo.removeFirst()
                        queueOne.addLast(remove)
                        oneSum += remove
                        twoSum -= remove
                    }
                    else{
                        return answer
                    }
                    answer ++

                    if (answer > limit)
                        return -1
                }
            }
            return answer
        }
    }

}