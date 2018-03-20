package practices

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * </p>
 **/

object Test {
    fun test(matrix: Array<Array<Int>>?, n: Int?): Boolean {
        if (matrix == null || n == null || matrix.isEmpty() || matrix[0].isEmpty()) return false
        val rows = matrix.size
        val cols = matrix[1].size
        var i = 0
        var j = cols - 1
        while (i < rows && j >= 0) {
            val cmp = matrix[i][j].compareTo(n)
            when {
                cmp < 0 -> ++i
                cmp > 0 -> --j
                else -> return true
            }
        }
        return false
    }

}


fun main(args: Array<String>) {
    val n = 3
    val array2d = Array(n, { it -> arrayOf(n * it + 1, n * it + 2, n * it + 3) })
    println(Test.test(array2d, 10))
}