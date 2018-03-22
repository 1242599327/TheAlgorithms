package practices

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。
 * 输入一个递增排序的数组的一个旋转， 输出旋转数组的最小元素。
 * 例如数组{3，4, 5, 1, 2 ｝为｛ l1,2,3, 4，5}的一个旋转，该数组的最小值为 1。
 *
 * 按照一般思路,无论我们从哪一头遍历,复杂度都是O(N)
 * 二分法?
 *
 **/


fun finMin(a: Array<Int>, low: Int, high: Int): Int {
    if (low == high - 1) {
        if (a[low] < a[high]) return a[low]
        else a[high]
    }
    var lo = low
    var hi = high
    val mid = lo + (hi - lo) / 2
    if (a[lo] == a[mid] && a[hi] == a[mid]) return a[low + 1] // 类似[1,0,1,1,1]
    if (a[lo] > a[mid] && a[hi] > mid) {
        hi = mid - 1
    } else if (a[lo] < a[mid] && a[hi] < mid) {
        lo = mid + 1
    } else {

    }
    return finMin(a, lo, hi)
}

fun main(args: Array<String>) {
    val a = arrayOf(3, 4, 5, 1, 2, 3)

    println(finMin(a, 0, a.size - 1))
}