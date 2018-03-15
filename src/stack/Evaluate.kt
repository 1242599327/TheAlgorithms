package stack

import java.util.*

/**
 * Created by sinyuk on 2018/3/3.
 *
 * <h1>Dijkstra的双栈算数表达式求值算法<h1/>
 */
object Evaluate {
    private val OPERATION_ARRAY = arrayListOf('+', '-', '*', '/')
    fun calculate(string: String): Int? {
        val operations = Stack<Char>()
        val results = Stack<Int>()
        for (char in string) {
            when {
                char.isDigit() -> {
                    (char.toInt() - 48).apply {
                        println("Push number: $this")
                        results.push(this)
                    }
                }
                OPERATION_ARRAY.contains(char) -> {
                    println("Push operation: $char")
                    operations.push(char)
                }
                ')' == char -> {
                    if (results.size >= 2 && operations.isNotEmpty()) {
                        operate(results.pop(), results.pop(), operations.pop()).apply {
                            println(" ==> $this")
                            results.push(this)
                        }
                    }
                }
            }
        }
        return if (results.isEmpty()) 0 else results.pop()

    }


    private fun operate(v1: Int, v2: Int, operation: Char): Int {
        print("$v2 $operation $v1")
        return when (operation) {
            '+' -> v2 + v1
            '-' -> v2 - v1
            '*' -> v2 * v1
            '/' -> v2 / v1
            else -> throw IllegalArgumentException("Illegal operation: $operation")
        }
    }


}


fun main(args: Array<String>) {
    val string = "( 1 + (( 2 + 3 ) * ( 4 * 5 )))"
    println("Result: " + Evaluate.calculate(string))
}