package `twenty eighth Day`

import java.util.*;

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        var N = sc.nextInt()
        val B = sc.nextInt()
        val sb = StringBuilder()
        while (N > 0) {
            if (N % B >= 10) {
                sb.append((N % B - 10 + 'A'.code).toChar())
            } else sb.append((N % B + '0'.code).toChar())
            N /= B
        }
        println(sb.reverse())
    }

// 1010

// 1 1 0 0
// 0 1 