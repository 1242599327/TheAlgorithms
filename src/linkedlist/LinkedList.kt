package linkedlist

class Node<K, V> constructor(val key: K, var value: V? = null, var next: Node<K, V>? = null) {
    override fun toString() = if (next == null) {
        "[$key, $value, next = null]"
    } else {
        "[$key, $value]"
    }
}

class LinkedList<K, V> constructor(var head: Node<K, V>? = null) {

    companion object {
        fun <K, V> length(head: Node<K, V>?): Int {
            if (head == null) return 0
            var len = 0
            var node: Node<K, V>? = head
            while (node?.next != null) {
                len++
                node = node.next
            }
            return len
        }


        fun <K, V> find(head: Node<K, V>?, key: K): Node<K, V>? {
            if (head == null) return null
            var node = head
            while (node?.next != null) {
                if (node.key == key) return node
                node = node.next
            }
            return null
        }

        fun <K, V> add(head: Node<K, V>, node: Node<K, V>): Node<K, V> {
            var cursor: Node<K, V> = head
            while (cursor.next != null) {
                if (cursor.key == node.key) {
                    cursor.value = node.value
                    break
                }
                cursor = cursor.next!!
            }
            cursor.next = node
            return cursor
        }


        /**
         * 快慢指针法,复杂度O(N/2)
         *
         * @param head 头指针
         * @return 返回中间节点
         */
        fun <K, V> middle(head: Node<K, V>?): Node<K, V>? {
            if (head == null) return null
            var slow: Node<K, V> = head
            var fast: Node<K, V>? = head
            while (fast != null && fast.next != null) {
                fast = fast.next!!.next
                slow = slow.next!!
            }
            return slow
        }

        /**
         * @param head 头指针
         * @param offset 倒数第几个
         * @return 返回倒数第offset个节点
         */
        fun <K, V> lastIndexOf(head: Node<K, V>?, offset: Int): Node<K, V>? {
            if (head == null) return null
            var i = 1
            var fast: Node<K, V>? = head!!
            while (i < offset) {
                if (fast == null) throw IndexOutOfBoundsException("Index out of bounds: $offset")
                fast = fast.next
                i++
            }

            var slow = head
            while (fast?.next != null) {
                fast = fast.next
                slow = slow!!.next
            }
            return slow
        }

        /**
         * Floyd判圈算法
         *
         * @param head 头指针
         * @return 返回该链表是否是循环链表
         */
        fun <K, V> loop(head: Node<K, V>?): Boolean {
            if (head == null) return false
            var slow = head
            var fast: Node<K, V>? = head.next

            while (fast != null && fast.next != null) {
                if (fast.key == slow?.key || fast.next?.key == slow?.key) return true
                fast = fast.next?.next
                slow = slow?.next
            }

            return false
        }
    }

    fun length() = Companion.length(head)

    fun middle() = Companion.middle(head)

    fun checkHead() {
        if (head == null) throw NullPointerException("Can't call this method with a null head")
    }

    fun lastIndexOf(offset: Int) = Companion.lastIndexOf(head, offset)

    fun loop() = Companion.loop(head)

    fun add(node: Node<K, V>): Node<K, V> = if (head == null) {
        head = node
        head!!
    } else {
        Companion.add(head!!, node)
    }

    fun find(key: K) = Companion.find(head, key)

    override fun toString(): String {
        if (head == null) return "Null"
        val sb = StringBuilder()
        var node: Node<K, V>? = head!!
        while (true) {
            sb.append(node)
            if (node?.next == null) {
                break
            } else if (node.next == head) {  // 对于环的处理
                sb.append("->").append(head)
                break
            } else {
                sb.append("->")
                node = node.next
            }
        }
        return sb.toString()
    }


}