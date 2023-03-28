package fourthDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val x = br.readLine().toInt()
    var first = 1
    var second = 1
    var condition = first - second // 2
    repeat(x-1){
        if (Math.abs(first - second)%2 == 0){
            if (condition+(first - second) == 0){
                second += 1
                condition = first - second
            }
            else{
                first -= 1
                second += 1
            }
        }
        else{
            if (condition+(first - second) == 0){
                first += 1
                condition = first - second
            }
            else{
                first += 1
                second -= 1
            }
        }
    }
    println("$first/$second")
}
//이것도 오래 걸렸다.
// condition은 first - second
// 입력받은 수만큼 반복문을 돌 때 first - second의 절대값이 홀수인지 짝수인지 결정함
// 왜냐면 짝수면 반복할 때 first는 1 줄고 second는 1이 늘거든
// 그 안에 조건문으로 이미 지정했던 condition과 (first-second)의 합이 0이 될때를 지정
// 0이 될 때 숫자가 하나 추가되는 시점이므로, second나 first에 1을 추가함
// 이 1을 추가하는 경우도 짝수냐, 홀수냐 규칙에 따름