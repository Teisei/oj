package teisei.leetcode;

/**
 * Created by Teisei on 2016/1/7.
 */
public class p_2_AddTwoNumbers {
    ListNode l1;
    ListNode l2;
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        p_2_AddTwoNumbers test = new p_2_AddTwoNumbers();
        test.run();

    }

    public void run() {
        init();
        ListNode l3 = addTwoNumbers(l1, l2);
        printList(l1);
        printList(l2);
        printList(l3);

    }

    public void init() {
        l1 = new ListNode(2);
        ListNode a = l1;
        a.next = new ListNode(4);
        a = a.next;
        a.next = new ListNode(3);


        l2 = new ListNode(5);
        a = l2;
        a.next = new ListNode(6);
        a = a.next;
        a.next = new ListNode(6);
    }

    public void printList(ListNode a) {
        if (a != null) {
            System.out.print(a.val);
        }
        a = a.next;
        while (a != null) {
            System.out.print(" -> ");
            System.out.print(a.val);
            a = a.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int flag = 0;
        int x_ = l1.val;
        int y_ = l2.val;
        int sum = x_ + y_;
        int sum_1 = sum / 10;
        int sum_2 = sum % 10;
        flag = sum_1 > 0 ? 1 : 0;
        ListNode resRoot = new ListNode(sum_2);
        ListNode zHead = resRoot;

        ListNode xHead = l1.next;
        ListNode yHead = l2.next;
        while (xHead != null || yHead != null || flag!=0) {
            x_ = xHead == null ? 0 : xHead.val;
            y_ = yHead == null ? 0 : yHead.val;
            flag = processOneDigit(x_, y_, flag, zHead);
            if(xHead!=null) xHead = xHead.next;
            if(yHead!=null) yHead = yHead.next;
            zHead = zHead.next;
        }
        return resRoot;
    }

    int processOneDigit(int x, int y, int flag, ListNode z) {
        int sum = x + y + flag;
        int sum_1 = sum / 10;
        int sum_2 = sum % 10;
        z.next = new ListNode(sum_2);
        flag = sum_1 > 0 ? 1 : 0;
        return flag;
    }
}
