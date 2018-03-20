package search

import java.util.*

class BinarySearchTree<K : Comparable<K>, V> constructor(var root: Node<K, V>? = null) {
    class Node<K, V> constructor(val key: K,
                                 var value: V? = null,
                                 var left: Node<K, V>? = null,
                                 var right: Node<K, V>? = null,
                                 var n: Int = 0)


    fun size() = size(root)

    private fun size(node: Node<K, V>?) = node?.n ?: 0

    fun get(key: K) = get(root, key)

    private fun get(node: Node<K, V>?, key: K): V? = if (node == null) {
        null
    } else {
        val cmp = key.compareTo(node.key)
        when {
            cmp < 0 -> get(node.left, key)
            cmp > 0 -> get(node.right, key)
            cmp == 0 -> node.value
            else -> null
        }
    }


    fun put(key: K, value: V?): Node<K, V> = put(root, key, value)

    private fun put(node: Node<K, V>?, key: K, value: V?): Node<K, V> = if (node == null) {
        Node(key, value, n = 1)
    } else {
        val cmp = key.compareTo(node.key)
        when {
            cmp < 0 -> node.left = put(node.left, key, value)
            cmp > 0 -> node.right = put(node.right, key, value)
            cmp == 0 -> node.apply { this.value = value }
        }
        node.n = size(node.left) + size(node.right)
        node
    }


    fun toFlatString() = toFlatString(root)

    private fun toFlatString(node: Node<K, V>?) {
        if (node == null) {
            print("🙂 , ")
            return
        } else {
            print("[${node.key},${node.value}] , ")
            toFlatString(node.left)
            toFlatString(node.right)
        }
    }


}

fun main(args: Array<String>) {
    val tree = BinarySearchTree(BinarySearchTree.Node(2, "A"))
    tree.put(1, "A")
    tree.put(3, "A")
    tree.toFlatString()
}

