package practices

import linkedlist.Node


object DeteleNodeTest {
    fun <K, V> deleteNode(head: Node<K, V>, target: Node<K, V>) {

        if (target.next == null) {
            if (target.key == head.key) { // 删除头节点

            } else {    // 删除尾节点
                var node = head
                while (node.next!!.next != null) {
                    node = node.next!!
                }
                node.next = null
            }
        } else {
            target.value = target.next!!.value
            target.next = target.next!!.next
        }
    }
}