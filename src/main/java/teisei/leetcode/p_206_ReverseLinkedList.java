package teisei.leetcode;

/**
 * Created by Teisei on 2016/3/15.
 */
public class p_206_ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode a=null, b=head, c;
        while(b!=null){
            c=b.next;

            b.next=a;
            a=b;
            b=c;
        }
        return a;
    }
}
