package teisei.leetcode;

/**
 * Created by Teisei on 2016/3/3.
 */
public class p_24_SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        p_24_SwapNodesInPairs test = new p_24_SwapNodesInPairs();
        test.run();
    }

    public void run() {
        ListNode head = new ListNode(1);
        ListNode p = head;
//        p.next = new ListNode(2);p=p.next;
//        p.next = new ListNode(3);p=p.next;
//        p.next = new ListNode(4);p=p.next;
//        p.next = new ListNode(5);p=p.next;
//        p.next = new ListNode(6);p=p.next;
//        p.next = new ListNode(7);p=p.next;
//        p.next = new ListNode(8);p=p.next;
//        p.next = new ListNode(9);p=p.next;
        printList(head);
        printList(swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    public ListNode swap(ListNode a) {
        if (a == null) return null;
        ListNode b = a.next;
        if (b == null) return a;
        a.next = swap(b.next);
        b.next = a;
        return b;
    }

    public void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }
}
