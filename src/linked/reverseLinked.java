package linked;

/**
 * @program: LeetCode
 * @description: 反转链表
 * @author: maple
 * @create: 2020-04-18 14:19
 **/
public class reverseLinked {
    static class Node {
        Node(int val){
            this.val = val;
        }
        int val;
        Node next;
    }

//    static void reverseLinked(Node head) {
//        Node pre = null;
//        Node next = null;
//        while (head.next != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//    }

    static Node reverse(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;

        }
        return pre;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);

        Node node1 = reverse(node);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

}
