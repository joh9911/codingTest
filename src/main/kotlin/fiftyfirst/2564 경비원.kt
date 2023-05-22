package fiftyfirst
import java.io.*
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (w,h) = br.readLine().split(' ').map{it.toInt()}
    val storeCnt = br.readLine().toInt()
    val north = Array(w+1){0}
    val south = Array(w+1){0}
    val east = Array(h+1){0}
    val west = Array(h+1){0}
    repeat(storeCnt){
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        when(a){
            1 -> north[b] = 1
            2 -> south[b] = 1
            3 -> west[b] = 1
            4 -> east[b] = 1
        }
    }
    val (a,b) = br.readLine().split(' ').map{it.toInt()}
    when(a){
        1 -> {
            var westMin = 0
            for (index in west.indices){
                if (west[index] == 1){
                    westMin += b + index
                }
            }
            var eastMin = 0
            for (index in east.indices){
                if (east[index] == 1){
                    eastMin += (w - b) + index
                }
            }
            var southMin = 0
            for (index in south.indices){
                if (south[index] == 1){
                    southMin += Math.min(index + b, w - index + w - b) + h
                }
            }
            var northMin = 0
            for (index in north.indices){
                if (north[index] == 1){
                    northMin += Math.abs(b - index)
                }
            }
            println(westMin + eastMin + southMin + northMin)
        }
        2 -> {
            var westMin = 0
            for (index in west.indices){
                if (west[index] == 1){
                    westMin += b + h - index
                }
            }
            var eastMin = 0
            for (index in east.indices){
                if (east[index] == 1){
                    eastMin += (w - b) + h - index
                }
            }
            var northMin = 0
            for (index in north.indices){
                if (north[index] == 1){
                    northMin += Math.min(index + b, w - index + w - b) + h
                }
            }
            var southMin = 0
            for (index in south.indices){
                if (south[index] == 1)
                    southMin += Math.abs(b - index)
            }
            println(westMin + eastMin + northMin + southMin)
        }
        3 -> {
            var southMin = 0
            for (index in south.indices){
                if (south[index] == 1){
                    southMin += h - b + index
                }
            }
            var northMin = 0
            for (index in north.indices){
                if (north[index] == 1){
                    northMin += b + index
                }
            }
            var eastMin = 0
            for (index in east.indices){
                if (east[index] == 1){
                    eastMin += Math.min(index + b, h - index + h - b) + w
                }
            }
            var westMin = 0
            for (index in west.indices){
                if (west[index] == 1)
                    westMin += Math.abs(index - b)
            }
            println(southMin + northMin + eastMin + westMin)
        }
        4 -> {
            var southMin = 0
            for (index in south.indices){
                if (south[index] == 1){
                    southMin += h - b +  w - index
                }
            }
            var northMin = 0
            for (index in north.indices){
                if (north[index] == 1){
                    northMin += b + w - index
                }
            }
            var westMin = 0
            for (index in west.indices){
                if (west[index] == 1){
                    westMin += Math.min(index + b, h - index + h - b) + w
                }
            }
            var eastMin = 0
            for (index in east.indices){
                if(east[index] == 1)
                    eastMin += Math.abs(index - b)
            }
            println(southMin + northMin + westMin + eastMin)
        }
    }
}