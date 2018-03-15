package linkedlist;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by sinyuk on 2018/3/13.
 */
public class Node {
    @NotNull
    public Comparable value;

    public Node next = null;

    public Node(@NotNull Comparable value) {
        this.value = value;
    }


    public static int length(Node head) {
        if (head == null) return 0;
        int len = 0;
        while (head.next != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * @param head
     */
    public static void checkHead(Node head) {
        if (head == null) throw new NullPointerException("Can't call this method with a null head");
    }

    /**
     * @param head
     * @param index
     */
    public static void checkIndex(Node head, int index) {
        if (index < 0 || index >= length(head))
            throw new IndexOutOfBoundsException("Index out of linked list bounds, length: " + length(head) + ", index: " + index);
    }

    public static Node getNodeAt(Node head, int index) throws IndexOutOfBoundsException, NullPointerException {
        checkHead(head);
        checkIndex(head, index);

        Node nextNode = head;

        while (nextNode.next != null && index > 0) {
            nextNode = nextNode.next;
            index--;
        }

        return nextNode;
    }

    /**
     * @param head
     * @param value
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Nullable
    public static Node findNodeOf(Node head, Comparable value) throws IndexOutOfBoundsException {
        checkHead(head);
        Node nextNode = head;
        do {
            if (nextNode.value.equals(value)) return nextNode;
            nextNode = nextNode.next;
        } while (nextNode.next != null);

        return null;
    }


    /**
     * 快慢指针法,复杂度O(N/2)
     *
     * @param head
     * @return
     */
    public static Node middle(Node head) {
        checkHead(head);

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    /**
     * Floyd判圈算法
     *
     * @param head
     * @return
     */
    public static boolean isLoop(Node head) {
        checkHead(head);

        Node slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow || fast.next == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }


    public static Node getLastIndexNode(Node head, int index) {
        checkHead(head);
        checkIndex(head, index);
        Node slow = head, fast = head;
        for (int i = 1; i < index; i++) {
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next;
            }
        } // 移动快指针到指定位置

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }


    public static Node deleteLastIndexNode(Node head, int index) {
        checkHead(head);
        checkIndex(head, index);
        Node slow = head, fast = head;
        for (int i = 0; i < index; i++) {
            //fast指针指向倒数第1个节点的时候，就是要删除head
            if (fast.next == null) {
                return head;
            } else {
                fast = fast.next;
            }
        } // 移动fast指针到指定位置

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}