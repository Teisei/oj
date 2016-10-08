package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/2/26.
 */
public class p_19_RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode head;

    public static void main(String[] args) {
        p_19_RemoveNthNodeFromEndOfList test = new p_19_RemoveNthNodeFromEndOfList();
        test.init();
        test.printListNode(test.head);
        test.run();
    }


    public void init() {
        head = new ListNode(0);
        ListNode p = head;
        for(int i = 1;i<10;i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
    }

    public void run() {
        printListNode(removeNthFromEnd(head, 10));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        if (n < 1 || n > len) {
            return head;
        }
        n = len - n + 1;
        System.out.println(n);
        if (n == 1) {
            return head.next;
        }
        ListNode p1 = head, p2 = p1.next;
        for (int i = 1; i < n - 1 && p2 != null; i++) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p2.next;
        return head;
    }

    public void printListNode(ListNode h) {
        ListNode p = h;
        while (p != null) {
            System.out.print(p.val + "-->");
            p = p.next;
        }
        System.out.println();
    }
}
