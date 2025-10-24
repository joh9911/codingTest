package fiftyfirst_sixtieth.fiftysixth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    data class Person(
        val name: String,
        val day: Int,
        val month: Int,
        val year: Int
    )
    val arr = arrayListOf<Person>()
    repeat(n){
        val input = br.readLine().split(' ')
        arr.add(Person(input[0], input[1].toInt(), input[2].toInt(), input[3].toInt()))
    }
    arr.sortWith(compareBy<Person>{it.year}
        .thenBy{it.month}
        .thenBy{it.day})

    println(arr.last().name)
    println(arr.first().name)

}