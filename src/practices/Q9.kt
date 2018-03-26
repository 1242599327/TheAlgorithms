package practices

/**
 *  输入数字n，按顺序打印出1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
 *
 *  陷阱：考虑大数问题，就是输入的数字非常大的情况，如100，怎么表示100位的数呢，可以用字符串保存。
 *
 **/


fun print1ToNDigits(n: Int, arr: IntArray) {
    if (n >= arr.size) {
        // 可以输入数组的值 这里就不删去0了
        println(arr.contentToString())
    } else {
        for (i in 0..9) {
            arr[n] = i
            print1ToNDigits(n + 1, arr)
        }
    }
}


fun main(args: Array<String>) {
    val n = 2
    val a = IntArray(n)
    print1ToNDigits(0, a)
}