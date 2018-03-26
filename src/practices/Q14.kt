package practices

import linkedlist.Node
import java.util.*

/**
 * 所以两个有公共结点而部分重舍的链衰，拓扑形状看起来像一个 Y， 而不可能像 X
 * 题目：输入两个链表，找出它们的第一个公共结点。
 *
 **/

/**
 * 利用栈 空间复杂度: O(m+n) 时间复杂度: O(m+n)
 */
fun findSameNode1(head1: Node<String, Int>, head2: Node<String, Int>): Node<String, Int>? {
    val stack1 = Stack<Node<String, Int>>()
    val stack2 = Stack<Node<String, Int>>()
    var node: Node<String, Int>? = head1
    while (node?.next != null) {
        stack1.push(node)
        node = node.next
    }
    node = head2
    while (node?.next != null) {
        stack2.push(node)
        node = node.next
    }

    while (stack1.isNotEmpty() && stack2.isNotEmpty()) {
        if (stack1.pop() == stack2.pop()) return stack1.pop()
    }

    return null
}


/**
 * 时间复杂度: O(m+n)
 */
fun findSameNode(head1: Node<String, Int>, head2: Node<String, Int>): Node<String, Int>? {
    var length1 = 1
    var length2 = 1
    var node1: Node<String, Int>? = head1
    while (node1?.next != null) {
        length1++
        node1 = node1.next
    }
    var node2: Node<String, Int>? = head1

    while (node2?.next != null) {
        length2++
        node2 = node2.next
    }

    when {
        length1 == length2 -> return if (node1 == node2) node1 else null
        length1 > length2 -> {
            node1 = head1
            node2 = head2
            for (i in 1..length1) {
                if (i > length1 - length2) {
                    if (node1 == node2) return node1
                    node2 = node2?.next
                }
                node1 = node1?.next
            }
        }
        else -> {
            node1 = head1
            node2 = head2
            for (i in 1..length2) {
                if (i > length2 - length1) {
                    if (node1 == node2) return node1
                    node1 = node1?.next
                }
                node2 = node2?.next
            }
        }
    }

    return null
}