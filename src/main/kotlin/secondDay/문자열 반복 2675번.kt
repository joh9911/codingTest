package secondDay
import java.io.*
import java.util.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t){
        val token = StringTokenizer(br.readLine())
        val repeatNum = token.nextToken().toInt()
        val word = token.nextToken()
        for (index in word.indices){
            for (index1 in 0 until repeatNum){
                print(word[index])
            }
        }
        print("\n")
    }
}
