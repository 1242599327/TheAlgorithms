package practices

/**
 * O（n）时间 O（1）空间实现斐波那契数列
 * n = 0 , 0
 * n = 1 , 1
 * n > 1 , f(n-1) + f(n-2)
 **/


fun fibonacci(n: Int) = when (n) {
    0 -> 0
    1 -> 1
    else -> {
        var i = 2
        var sum = 0
        var f1 = 0
        var f2 = 1
        while (i <= n) {
            sum = f1 + f2
            f1 = f2
            f2 = sum
            i++
        }
        sum
    }
}


fun main(args: Array<String>) {
    var i = 7
    while (i >= 0) {
        println("f($i) = " + fibonacci(i))
        i--
    }
}