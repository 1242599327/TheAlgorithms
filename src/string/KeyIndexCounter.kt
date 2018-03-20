package string

import java.util.*

object KeyIndexCounter {
    fun count(a: Array<Node>, max: Int): Array<Node> {
        val R = max + 1
        val count = IntArray(R + 1)
        for (node in a) count[node.key + 1]++
        var i = 0
        while (i < R) count[i + 1] += count[i++]
        println("频率统计: " + Arrays.toString(count))
        @Suppress("UnnecessaryVariable")
        val aux = a
        for (node in a) aux[count[node.key]++] = node
        return aux
    }
}

data class Node constructor(val key: Int, var value: String? = null) {
    override fun toString(): String {
        return "[$key , $value]"
    }
}


fun main(args: Array<String>) {
    val a = arrayOf(
            Node(1, "Maybe"),
            Node(2, "gh"),
            Node(2, "KaKa"),
            Node(3, "YYF"),
            Node(1, "Burning"),
            Node(3, "Miracle"),
            Node(2, "Mu"),
            Node(2, "NoTail"),
            Node(1, "Universe"))

    println(Arrays.toString(KeyIndexCounter.count(a, 3)))
}