package sixtyfirst_seventieth.seventieth
class Solution3 {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val w = park.first().length
        val h = park.size
        var startX = 0
        var startY = 0
        for (index in park.indices){
            if (park[index].contains('S')){
                startX = park[index].indexOf('S')
                startY = index
                break
            }
        }
        for (index in routes.indices){
            val d = routes[index].split(' ')
            when(d.first()){
                "E" -> {
                    val movedX = startX + d.last().toInt()
                    if (movedX > w - 1) continue
                    var tag = false
                    for (i in 0 .. d.last().toInt()){
                        if (park[startY][startX + i] == 'X')
                            tag = true
                    }
                    if (tag) continue
                    startX = movedX
                }
                "W" -> {
                    val movedX = startX - d.last().toInt()
                    if (movedX < 0) continue
                    var tag = false
                    for (i in 0 .. d.last().toInt()){
                        if (park[startY][startX - i] == 'X')
                            tag = true
                    }
                    if (tag) continue
                    startX = movedX
                }
                "S" -> {
                    val movedY = startY + d.last().toInt()
                    if (movedY > h - 1) continue
                    var tag = false
                    for (i in 0 .. d.last().toInt()){
                        if (park[startY + i][startX] == 'X')
                            tag = true
                    }
                    if (tag) continue
                    startY = movedY
                }
                "N" -> {
                    val movedY = startY - d.last().toInt()
                    if (movedY < 0) continue
                    var tag = false
                    for (i in 0 .. d.last().toInt()){
                        if (park[startY - i][startX] == 'X')
                            tag = true
                    }
                    if (tag) continue
                    startY = movedY
                }
            }
        }
        val ans = IntArray(2)
        ans[0] = startY
        ans[1] = startX
        return ans
    }
}