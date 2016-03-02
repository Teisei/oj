package teisei.leetcode;

/**
 * Created by Teisei on 2016/3/1.
 */
public class p_237_DeleteNodeInALinkedList {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) {
        if(node==null) return;
        else if(node.next==null) return;
        else{
            node.val=node.next.val;
            if(node.next.next==null)
                node.next=null;
            else
                deleteNode(node.next);
        }
    }
}
