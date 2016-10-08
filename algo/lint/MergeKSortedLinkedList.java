package teisei.algo.lint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Teisei on 2016/4/20.
 */
public class MergeKSortedLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }



    public ListNode mergeKLists(List<ListNode> lists) {
        List<ListNode> heap = new ArrayList<ListNode>();
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        ListNode head = null;
        ListNode current = null;
        if (heap.size() == 0) return null;
        minHeapify(heap);
        while (heap.size() != 0) {
            if (head == null) {
                head = heap.get(0);
                current = heap.get(0);
            } else {
                current.next = heap.get(0);
                current = current.next;
            }

            if (current.next != null) {
                heap.set(0, current.next);
                heapify(heap, 0);
            } else {
                heap.remove(0);
                minHeapify(heap);
            }
        }
        return head;
    }

    public void heapify(List<ListNode> heap, int index) {
        int position = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(left < heap.size() && heap.get(left).val < heap.get(position).val) {
            position = left;
        }

        if(right < heap.size() && heap.get(right).val < heap.get(position).val) {
            position = right;
        }

        if (position != index) {
            ListNode temp = heap.get(position);
            heap.set(position, heap.get(index));
            heap.set(index, temp);
            heapify(heap, position);
        }
    }

    public void minHeapify(List<ListNode> heap) {
        for (int i = heap.size()/2 - 1; i >= 0; i--) {
            heapify(heap, i);
        }
    }

    /**
     * 堆实现
     * @param lists
     * @return
     */
    public ListNode mergeKLists0(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
        if (lists.size() == 1)
            return lists.get(0);
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0), rear = head;
        head.next = null;
        for (ListNode node : lists) {
            if (node != null)
                heap.offer(node);
        }

        while (!heap.isEmpty()) {
            ListNode p = heap.poll();
            rear.next = p;
            rear = rear.next;
            p = p.next;
            if (p != null)
                heap.offer(p);
        }
        rear.next = null;
        return head.next;
    }


    public ListNode mergeKLists4(List<ListNode> lists) {

        // write your code here
        if(lists==null) return null;
        int n = lists.size();
        if(n==0) return null;

        List<ListNode> tmpList;
        ListNode l1, l2, l_merged;
        while (n > 1) {
            tmpList = new ArrayList<>();
            for(int i=0;i<n;i+=2) {
                l1 = lists.get(i);
                l2 = (i + 1 < n) ? lists.get(i + 1) : null;
                l_merged = merge2Lists(l1, l2);
                tmpList.add(l_merged);
            }
            lists = tmpList;
            n = lists.size();
        }
        return lists.get(0);
    }



    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(-1);
        ListNode p = l1, q = l2, point = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                point.next = p;
                p = p.next;
            } else {
                point.next = q;
                q = q.next;
            }
            point = point.next;
        }
        while (p != null) {
            point.next = p;
            p = p.next;
            point = point.next;
        }
        while (q != null) {
            point.next = q;
            q = q.next;
            point = point.next;
        }
        return head.next;
    }
}
