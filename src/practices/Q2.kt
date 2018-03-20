package practices

import java.util.*

/**
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数appendTail 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 * </p>
 *
 **/

class StackQueue<T> {
    private val stack1 = Stack<T?>()
    private val stack2 = Stack<T?>()

    fun appendTail(node: T?) {
        if (stack2.isNotEmpty()) {
            stack2.push(node)
        } else {
            stack1.push(node)
        }
    }

    fun deleteHead() = when {
        stack2.isNotEmpty() -> {
            while (stack2.isNotEmpty()) stack1.push(stack2.pop())
            stack1.pop()
        }
        stack1.isNotEmpty() -> {
            while (stack1.isNotEmpty()) stack2.push(stack1.pop())
            stack2.pop()
        }
        else -> null
    }
}