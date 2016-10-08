package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/2/26.
 */
public class p_21_MergeTwoSortedLists {
    public static void main(String[] args) {
        p_21_MergeTwoSortedLists test = new p_21_MergeTwoSortedLists();
        test.run();
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void run() {
        ListNode l1 = new ListNode(1);
        ListNode p = l1;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
//        p = p.next;
//        p.next = new ListNode(9);

        ListNode l2 = new ListNode(0);
        p = l2;
//        p.next = new ListNode(4);
//        p = p.next;
//        p.next = new ListNode(6);
//        p = p.next;
//        p.next = new ListNode(8);
//        p = p.next;
//        p.next = new ListNode(10);

        ListNode resNode = mergeTwoLists(l1, l2);
        p = resNode;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if(l2==null) return l1;
        ListNode head;
        ListNode p = l1, q = l2;
        if (p.val < q.val) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        ListNode w = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                w.next = p;
                p = p.next;
            } else {
                w.next = q;
                q = q.next;
            }
            w = w.next;
        }
        while (p != null) {
            w.next = p;
            w = w.next;
            p = p.next;
        }
        while (q != null) {
            w.next = q;
            w = w.next;
            q = q.next;
        }
        return head;
    }
}
