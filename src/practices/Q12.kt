package practices

import linkedlist.LinkedList
import linkedlist.Node

/**
 * 题目：在一个排序的链表中，如何删除重复的结点？
 **/


fun deduplicate(head: Node<String, Int>): Node<String, Int> {
    var dummyHead: Node<String, Int>? = Node(key = "")
    dummyHead!!.next = head
    while (dummyHead != null && dummyHead.next != null) {
        if (dummyHead.next!!.value?.equals(dummyHead.value) == true) {
            dummyHead.next = dummyHead.next!!.next
        } else {
            dummyHead = dummyHead.next
        }
    }
    return head
}


fun main(args: Array<String>) {
    val linkedList = LinkedList(Node(key = "A", value = 2))
    linkedList.add(Node(key = "B", value = 2))
    linkedList.add(Node(key = "C", value = 2))
    linkedList.add(Node(key = "D", value = 2))
    linkedList.add(Node(key = "E", value = 2))
    linkedList.add(Node(key = "F", value = 7))
    linkedList.add(Node(key = "G", value = 7))
    println(linkedList.toString())

    deduplicate(linkedList.head!!)
    println(linkedList.toString())
}