package sixtyfirst_seventieth.seventieth
class Solution1 {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val map = mutableMapOf<String,Int>()

        for (index in players.indices){
            map[players[index]] = index
        }

        for (index in callings.indices){
            val idx = map[callings[index]]!!
            val prevPlayer = players[idx - 1]
            players[idx - 1] = callings[index]
            players[idx] = prevPlayer
            map[callings[index]] = map.getOrDefault(callings[index], 0) - 1
            map[prevPlayer] = map.getOrDefault(prevPlayer, 0) + 1
        }
        val arr = Array(players.size){""}
        map.forEach{
            arr[it.value] = it.key
        }
        return arr
    }
}