package practices

import sort.Utils.exchange
import java.util.*

/**
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 *
 **/


fun modalNumber(a: Array<Int>, lo: Int, hi: Int) {
    println("lo: $lo hi: $hi")
    val j = partition(a, lo, hi)
    val mid = lo + (hi - lo) / 2
    println(Arrays.toString(a))
    println("a[$j]: " + a[j])
    println("mid: $mid")
    if (mid == j) return
    when {
        j < mid -> modalNumber(a, lo, j)
        j > mid -> modalNumber(a, j, hi)
    }
}

fun partition(a: Array<Int>, lo: Int, hi: Int): Int {
    var i = lo
    var j = hi + 1
    val v = a[lo]
    while (true) {
        while (v > a[++i]) if (i == hi) break
        while (v < a[--j]) if (j == lo) break
        if (i >= j) break
        exchange(a, i, j)
    }
    exchange(a, lo, j)
    return j
}

fun main(args: Array<String>) {
    val a = arrayOf(2, 1, 1, 2, 2)
    val mid = a.size / 2
    modalNumber(a, 0, a.size - 1)
    println(a[mid])
}