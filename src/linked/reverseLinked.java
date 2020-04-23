package linked;

/**
 * @program: LeetCode
 * @description: 反转链表
 * @author: maple
 * @create: 2020-04-18 14:19
 **/
public class reverseLinked {
    class Node {
        int val;
        Node next;
    }

    static void reverseLinked(Node head) {
        Node pre = null;
        Node next = null;
        while (head.next != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }
}
