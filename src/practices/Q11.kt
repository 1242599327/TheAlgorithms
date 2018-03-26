package practices

/**
 * 二进制中 1 的个数
 **/

/**
 * 图样图森破
 */
fun numOf1InBinary(n: Int): Int {
    var i = 0
    var a = n
    while (a != 0) {
        if (a % 2 == 1) i++
        print(a % 2)
        a /= 2
    }
    println()
    return i
}


fun numOf1InBinary2(n: Int): Int {
    var i = 0
    var a = n
    for (j in 0..31) {
        i += a and 1
        a = a ushr 1
    }
    return i
}

fun numOf1InBinary3(n: Int): Int {
    var n = n
    // 记录数字中1的位数
    var result = 0
    // 数字的二进制表示中有多少个1就进行多少次操作
    while (n != 0) {
        result++
        // 从最右边的1开始，每一次操作都使n的最右的一个1变成了0，
        // 即使是符号位也会进行操作。
        n = n - 1 and n
    }
    // 返回求得的结果
    return result
}

fun main(args: Array<String>) {
//    println(numOf1InBinary(10).toString())
    println(numOf1InBinary2(10).toString())
//    println(numOf1InBinary3(10).toString())

}