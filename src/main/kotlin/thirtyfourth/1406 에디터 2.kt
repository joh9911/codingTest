package thirtyfourth
import java.io.*
import java.util.*
//문제 유형을 보고 품
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var string = br.readLine()
    val m = br.readLine().toInt()
    val stack = LinkedList<Char>()
    val extraStack = LinkedList<Char>()
    for (index in string.indices){
        stack.add(string[index])
    }
    repeat(m){
        val input = br.readLine()
        when(input[0]){
            'P' -> stack.add(input[2])
            'L' -> if (stack.isNotEmpty()) extraStack.addFirst(stack.removeLast())
            'D' -> if (extraStack.isNotEmpty()) stack.add(extraStack.removeFirst())
            'B' -> if(stack.isNotEmpty()) stack.removeLast()
        }
    }
    while (extraStack.isNotEmpty()){
        stack.addLast(extraStack.removeFirst())
    }
    while (stack.isNotEmpty()){
        bw.write("${stack.removeFirst()}")
    }
    //이걸 썻을 때는 시간초과가 뜸 왤까
    // 알았음
    // linkedlist에서 각 원소를 순회하는 것은 시간복잡도가 많이듬
    // 인덱스를 이용해서 get(index)매서드를 사용하여 접근하고 잇는데
    // 이럴 대 시간 복잡도는 O(n)임
    // 삭제 제거를 함으로써 O(1) 의 시간복잡도를 이용해야함
    // 조회할 경우, arrayList를 이용하면 O(1)을 이용할 수 있음
    for (index in stack.indices){
        bw.write("${stack[index]}")
    }
    for (index in extraStack.indices){
        bw.write("${extraStack[index]}")
    }
    bw.flush()
}