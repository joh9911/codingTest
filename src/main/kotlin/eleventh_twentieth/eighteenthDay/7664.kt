package eleventh_twentieth.eighteenthDay

import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val t = br.readLine().toInt()
    repeat(t){
        val queue = LinkedList<Int>()
        val maxQueue = LinkedList<Int>()
        val minQueue = LinkedList<Int>()
        val k = br.readLine().toInt()
        var isEmpty = false
        for (index in 0 until k){
            val(string, int) = br.readLine().split(' ')
            if (string == "I"){
                val value = int.toInt()
                if (queue.isEmpty()){
                    queue.add(value)
                    isEmpty = false
                }
                else{
                    if (value >= queue.first){
                        if (maxQueue.isEmpty())
                            maxQueue.addFirst(value)
                        else{
                            if (value > maxQueue.first)
                                maxQueue.addFirst(value)
                            else
                                maxQueue.addLast(value)
                        }
                    }
                    else{
                        if (minQueue.isEmpty())
                            minQueue.addLast(value)
                        else{
                            if (value < minQueue.last)
                                minQueue.addLast(value)
                            else
                                minQueue.addFirst(value)
                            }
                        }
                    }
                }
            else{
                val value = int.toInt()
                if (queue.isNotEmpty()){
                    if (value == -1){
                        if (minQueue.isNotEmpty())
                            minQueue.removeLast()
                        else{
                            queue.removeFirst()
                            if (maxQueue.isEmpty())
                                isEmpty = true
                        }
                    }
                    else{
                        if (maxQueue.isNotEmpty())
                            maxQueue.removeFirst()
                        else{
                            queue.removeFirst()
                            if (minQueue.isEmpty())
                                isEmpty = true
                        }
                    }
                }
                else{
                    if (value == -1){
                        if (maxQueue.isNotEmpty())
                            maxQueue.removeLast()
                        else if (minQueue.isNotEmpty())
                            minQueue.removeLast()
                        else{
                            isEmpty = true
                        }
                    }
                    else{
                        if (minQueue.isNotEmpty())
                            minQueue.removeFirst()
                        else if (maxQueue.isNotEmpty())
                            maxQueue.removeFirst()
                        else{
                            isEmpty = true
                        }
                    }
                }
            }
        }

        if (isEmpty)
            bw.write("EMPTY\n")
        else{
            var max = 0
            var min = 0
            if (queue.isNotEmpty()){
                if (maxQueue.isEmpty())
                    max = queue.first
                else
                    max = maxQueue.first
                if (minQueue.isEmpty())
                    min = queue.first
                else
                    min = minQueue.last
            }
            else{
                if (maxQueue.isEmpty()){
                    max = minQueue.first
                    min = minQueue.last
                }
                if (minQueue.isEmpty()){
                    max = maxQueue.first
                    min = maxQueue.last
                }
            }
            bw.write("$max $min\n")
        }
    }
    bw.flush()
}