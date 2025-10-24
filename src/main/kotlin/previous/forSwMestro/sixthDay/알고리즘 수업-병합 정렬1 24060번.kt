package sixthDay

import java.util.*
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val m = MergeArray(n, k)
    for (i in 0 until n) m.A[i] = sc.nextInt()
    m.merge_sort(0, n - 1) //배열은 0부터 n-1까지이기 때문에
    println(-1)
    sc.close()
}

internal class MergeArray(n: Int, k: Int) {
    var A: IntArray
    private val tmp: IntArray
    private val k: Int
    private var cnt: Int
    fun merge_sort(p: Int, r: Int) {        //배열 A를 클래스 멤버 변수로
        val q: Int
        if (p < r) {
            q = (p + r) / 2
            merge_sort(p, q)
            merge_sort(q + 1, r)
            merge(p, q, r)
        }
    }

    private fun merge(p: Int, q: Int, r: Int) {
        var i = p
        var j = q + 1
        var t = 0 //배열은 0부터 시작하기에 0으로 초기화
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) tmp[t++] = A[i++] else tmp[t++] = A[j++]
        }
        while (i <= q) tmp[t++] = A[i++]
        while (j <= r) tmp[t++] = A[j++]
        i = p
        t = 0 //바로 위 주석과 같은 이유
        while (i <= r) {
            A[i++] = tmp[t++]
            cnt++
            if (cnt == k) {
                println(A[i - 1])
                System.exit(0)
            }
        }
    }

    init {
        A = IntArray(n)
        tmp = IntArray(n)
        this.k = k
        cnt = 0
    }
}



