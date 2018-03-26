package practices

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串 abc。
 * 则打印出由字符 a、b、c 所能排列出来的所有字符串 abc、acb、bac 、bca、cab 和 cba 。
 *
 * 首先,能想到可以用典型的递归思路: a,bcd  b,acd c,abc
 */

fun permutation(chars: CharArray, index: Int, length: Int) {
    if (index == length) {
        println(chars.contentToString())
        return
    }
    var i = index
    while (i < length) {
        if (i != index && chars[i] == chars[index]) continue
        if (i != index) swapChars(chars, i, index)
        permutation(chars, index + 1, length)
        ++i
    }
}

fun swapChars(array: CharArray, i: Int, j: Int) {
    if (i == j) return
    val tmp = array[i]
    array[i] = array[j]
    array[j] = tmp
}

fun main(args: Array<String>) {
    val string = "abc"
    permutation(string.toCharArray(), 0, string.length)
}