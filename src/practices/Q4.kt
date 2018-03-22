package practices

import java.util.*

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 **/

fun swapOddAndEven(a: Array<Int>): Array<Int> {
    if (a.size == 1) return a
    var i = 0
    var j = a.size - 1

    while (i < j) {
        if (isOdd(a[i])) i++  // ==> 找到第一个偶数
        else while (i < j) {
            if (isOdd(a[j])) { // <=== 找到第一个奇数
                val tmp = a[j] // <===> 互换位置
                a[j] = a[i]
                a[i] = tmp
                j--
                break
            }
            j--
        }

    }
    return a
}

fun isOdd(n: Int): Boolean = n % 2 != 0

fun main(args: Array<String>) {
    val a = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    println(Arrays.toString(swapOddAndEven(a)))
}