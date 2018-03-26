package practices

import linkedlist.LinkedList
import linkedlist.Node

/**
 * 题目：一个链表中包含环，如何找出环的入口结点？
 *
 **/


fun main(args: Array<String>) {
    val linkedList = LinkedList(Node(key = "A", value = 1))
    linkedList.add(Node(key = "B", value = 2))
    linkedList.add(Node(key = "C", value = 3))
    linkedList.add(Node(key = "D", value = 4))
    linkedList.add(Node(key = "E", value = 5))
    linkedList.add(Node(key = "F", value = 6))
    val node = Node(key = "G", value = 7, next = linkedList.head)
    linkedList.add(node)
    println(linkedList.toString())
    println(findLoopEntry(linkedList.head!!))
}

fun findLoopEntry(head: Node<String, Int>): Node<String, Int>? {

    var fast: Node<String, Int>? = head
    var slow: Node<String, Int>? = head

    while (fast != null && fast.next != null) {
        fast = fast.next!!.next
        slow = slow!!.next
        if (fast == slow) break
    }

    if (fast == null || fast.next == null) {
        return null
    }

    fast = head
    while (fast != slow) {
        fast = fast!!.next
        slow = slow!!.next
    }
    return fast

}