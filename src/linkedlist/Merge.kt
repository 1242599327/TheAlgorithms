package linkedlist

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 **/

fun main(args: Array<String>) {
    val list1 = LinkedList(Node(key = "A", value = 1))
    list1.add(Node(key = "B", value = 2))
    list1.add(Node(key = "C", value = 3))
    list1.add(Node(key = "D", value = 4))
    println(list1.toString())

    val list2 = LinkedList(Node(key = "D", value = 5))
    list2.add(Node(key = "F", value = 6))
    list2.add(Node(key = "G", value = 7))
    list2.add(Node(key = "H", value = 8))
    println(list2.toString())

    println(LinkedList(merge(list1.head, list2.head)).toString())

    println(LinkedList(merge2(list1.head, list2.head)).toString())

}

// 使用的是递归的解法，不推荐，递归调用的时候会有方法入栈，需要更多的内存
fun merge(head1: Node<String, Int>?, head2: Node<String, Int>?): Node<String, Int>? {
    if (head1 == null) return head2
    if (head2 == null) return head1
    var temp = head1
    val cmp = temp.key.compareTo(head2.key)
    if (cmp < 0) {
        temp.next = merge(head1.next, head2)
    } else {
        temp = head2
        temp.next = merge(head2.next, head1)
    }
    return temp
}

//
fun merge2(head1: Node<String, Int>?, head2: Node<String, Int>?): Node<String, Int>? {
    if (head1 == null) return head2
    if (head2 == null) return head1
    var temp: Node<String, Int>
    var next1: Node<String, Int>? = head1
    var next2: Node<String, Int>? = head2
    val head: Node<String, Int>?
    if (next1!!.key < next2!!.key) {
        head = next1
        next1 = next1.next
    } else {
        head = next2
        next2 = next2.next
    }
    temp = head
    while (true) {
        when {
            next1 == null -> {
                temp.next = next2
                return head
            }
            next2 == null -> {
                temp.next = next1
                return head
            }
            else -> {
                if (next1.key < next2.key) {
                    temp.next = next1
                    next1 = next1.next
                    temp = temp.next!!
                } else {
                    temp.next = next2
                    next2 = next2.next
                    temp = temp.next!!
                }
            }
        }
        println(temp.key)
    }
}