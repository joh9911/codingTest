import java.util.*

object Main {
    private lateinit var gaps: IntArray
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val N = scanner.nextInt()
        val trees = IntArray(N)
        gaps = IntArray(N - 1)
        for (i in 0 until N) {
            trees[i] = scanner.nextInt()
            if (i > 0) {
                gaps[i - 1] = trees[i] - trees[i - 1]
            }
        }
        for (i in 0..gaps.size - 2) {
            gaps[i + 1] = gcd(gaps[i], gaps[i + 1])
        }
        val gap = gaps[gaps.size - 1]
        println((trees[N - 1] - trees[0]) / gap - (N - 1))
    }

    private fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b > 0) {
            val tmp = a
            a = b
            b = tmp % b
        }
        return a
    }
}