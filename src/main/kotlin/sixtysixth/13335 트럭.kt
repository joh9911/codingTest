package sixtysixth
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,w,l) = br.readLine().split(' ').map{it.toInt()}
    val list = br.readLine().split(' ').map{it.toInt()}


    val space = Array(w){0}
    var time = 0
    var idx = 0

    fun isAvailable(idx: Int, last: Int): Boolean{
        if (idx > list.size - 1)
            return false
        val weight = space.sum() + list[idx] - last
        return weight <= l
    }

    fun add(num: Int){
        space[0] = num
    }

    fun move(){
        var prevValue = space.first()
        for (index in 1 until space.size){
            val temp = space[index]
            space[index] = prevValue
            prevValue = temp
        }
    }

    while(true){
        if (idx > list.size - 1 && space.sum() == 0)
            break
        if (isAvailable(idx, space.last())){
            move()
            add(list[idx])
            idx ++
        }
        else{
            move()
            add(0)
        }
        time ++
    }
    println(time)
}

