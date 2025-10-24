package sixtyfirst_seventieth.seventieth

class `lv1 바탕화면 정리` {
    class Solution {
        fun solution(wallpaper: Array<String>): IntArray {
            var minX = Int.MAX_VALUE
            var minY = Int.MAX_VALUE
            var maxX = 0
            var maxY = 0
            for (i in wallpaper.indices){
                for (j in wallpaper[i].indices){
                    if (wallpaper[i][j] == '#'){
                        println(i)
                        println(j)
                        minX = Math.min(minX, j)
                        minY = Math.min(minY,i)
                        maxX = Math.max(maxX,j)
                        maxY = Math.max(maxY,i)
                    }
                }
            }
            var ans = IntArray(4)
            ans[0] = minY
            ans[1] = minX
            ans[2] = maxY + 1
            ans[3] = maxX + 1
            return ans

        }
    }
}