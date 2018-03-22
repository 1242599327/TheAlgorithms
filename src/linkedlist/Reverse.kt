package linkedlist

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 */
fun main(args: Array<String>) {
    val linkedList = LinkedList(Node(key = "A", value = 1))
    linkedList.add(Node(key = "B", value = 2))
    linkedList.add(Node(key = "C", value = 3))
    linkedList.add(Node(key = "D", value = 4))
    linkedList.add(Node(key = "E", value = 5))
    linkedList.add(Node(key = "F", value = 6))
    linkedList.add(Node(key = "G", value = 7))
    println(linkedList.toString())

    println(LinkedList(reverseOrder(linkedList.head)))
    println(LinkedList(reverseOrder2(linkedList.head)))
}

fun reverseOrder2(node: Node<String, Int>?): Node<String, Int>? {
    // 用于记录当前处理的结点的
    var curr = node
    // 用于记录反转后的链表的头结点
    var head: Node<String, Int>? = null
    // 用于记录当前结点的前驱结点
    // 前驱结点开始为null，因为了是反转后的最后一个结点的下一个结点，即null
    var next: Node<String, Int>?
    // 当前结点的下一个结点
    var prev: Node<String, Int>? = null

    // 对链表进行尾插法操作
    while (curr != null) {
        // 记录当前处理的结点，最后一个记录的结点就是反转后的头结点
        head = curr
        // 记录当然前下一个结点
        next = curr.next
        // 当前结点的下一个结点指向前驱结点，这样当前结点就插入到了反转链表的头部
        curr.next = prev
        // 记录当前结点为前驱结点
        prev = curr
        // 当前结点点移动到下一个结点
        curr = next
    }
    return head
}

fun reverseOrder(node: Node<String, Int>?): Node<String, Int>? {
    val dummyNode = Node<String, Int>("")
    var head = node
    var next: Node<String, Int>?
    while (head != null) {
        next = head.next             // 记录要处理的下一个结点
        head.next = dummyNode.next   // 当前结点的下一个结点指向逻辑头结点的下一个结点
        dummyNode.next = head        // 逻辑头结点的下一个结点指向当前处理的结点
        head = next
    }
    return dummyNode.next
}

