package secondDay

fun main(){
    val array = mutableSetOf<Int>()
    val selfArray = mutableSetOf<Int>()
    for (index in 1 .. 10000){
        selfArray.add(index)
    }
    for (index in 1..10000){
        calculator(index, array)
    }
    array.forEach{selfArray.remove(it)}

    selfArray.forEach{println(it)}

}

fun calculator(n: Int, array: MutableSet<Int>){
    var value = n
    while (true){
        val num = value + digitCal(value)
        if (array.contains(num))
            break
        if (num > 10000)
            break
        array.add(num)
        value = num
    }
}
fun digitCal(value: Int): Int {
    var value1 = value
    var ans = 0
    if (value < 10)
        return value1
    else{
        while (value1 > 9){
            ans += value1 % 10
            value1 /= 10
        }
        ans += value1
    }
    return ans
}
//이거하는데 무슨 1시간이 넘게 걸리냐
// 1부터 10000까지 저 수열을 set에 저장함
// 이 때 계산한 값이 set에 포함되어 있으면 break
// 1 ~ 10000 배열에서 set의 값들을 모두 뺌
// set의 시간 복잡도는 O(1)인 것을 활용할 수 있었음
