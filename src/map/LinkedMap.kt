package map

/**
 * 基于无序链表的符号表
 */
class LinkedMap<K, V> constructor(var head: Node<K, V>? = null) {
    class Node<K, V> constructor(val key: K, var value: V?, var next: Node<K, V>? = null) {
        override fun toString(): String {
            return "[$key , $value]=>${next?.key}"
        }
    }

    fun get(key: K): V? {
        if (head == null) return null
        var node: Node<K, V> = head!!
        while (true) {
            if (key == node.key) return node.value
            if (node.next == null) return null
            node = node.next!!
        }
    }

    fun put(key: K, value: V?): Node<K, V>? {
        if (head == null) return Node(key, value, null).apply { head = this }
        var node: Node<K, V>? = head!!
        while (true) {
            if (key == node?.key) return node!!.apply { this.value = value }
            if (node?.next == null) break
            node = node.next
        }

        return Node(key, value).apply { node!!.next = this }
    }

    fun delete(key: K): Node<K, V>? {
        if (head == null) return null
        var node: Node<K, V> = head!!
        if (node.key == key) return deleteHead()
        while (true) {
            if (node.next == null) return null
            if (key == node.next!!.key) {
                node = node.next!!
                return node
            }
            node = node.next!!
        }
    }

    fun isEmpty() = head == null

    fun size(): Int {
        var i = 0
        var node: Node<K, V>? = head
        while (node?.next != null) {
            node = node.next
            i++
        }
        return i
    }

    fun keys(): Set<K> {
        val set = HashSet<K>()
        var node: Node<K, V>? = head
        while (node?.next != null) {
            set.add(node.key)
            node = node.next
        }
        return set
    }

    fun entries(): Set<V?> {
        val set = HashSet<V?>()
        var node: Node<K, V>? = head
        while (node?.next != null) {
            set.add(node.value)
            node = node.next
        }
        return set
    }

    private fun deleteHead(): Node<K, V>? {
        head = head!!.next
        return head
    }

    override fun toString(): String {
        var str = ""
        var node: Node<K, V>? = head
        while (head != null) {
            str += "[${node!!.key},${node.value}]"
            if (node.next != null) {
                str += " , "
                node = node.next
            } else {
                break
            }
        }
        return str
    }

}

fun main(args: Array<String>) {
    val map = LinkedMap<String, String>()
    println("Put: " + map.put("A", "Alexander").toString())
    println("Put: " + map.put("B", "Alice").toString())
    println("Put: " + map.put("C", "Taylor").toString())
    println(map.toString())

    println("Put: " + map.put("A", null).toString())
    println(map.toString())

    println("Delete: " + map.delete("B"))
    println(map.toString())

}



