
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    /**

      Problem:
      merge k sorted list

      Constraints:
      1) k sorted list,
      2) merge them into a sorted list
      3) return the head of the merged list

      Idea
      1) divide and conquer
      suppose: average length of a list is n
      every elements should be scaned log n times,
      time: O(k * n * log k)
      space: O(k * n)

      2) use a min-heap
      put all heads into the heap,
      while heap is not empty,
      fetch the head and put it into the result list,
      replace with next,
      and re-heapify
      time: O(n * k * log k)
      space: O(k)


     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
     public ListNode mergeKLists(List<ListNode> lists) {
         if(lists == null || lists.size() == 0) return null;
         return merge(lists);
     }

     public ListNode merge(List<ListNode> lists){
         while(lists.size() > 1){
             List<ListNode> tmp = new ArrayList<>();
             for(int i = 0; i < lists.size(); i += 2) {
                 ListNode l1 = lists.get(i);
                 ListNode l2 = (i+1 < lists.size())? lists.get(i+1) : null;
                 tmp.add(merge_two_list(l1, l2));
             }
             lists = tmp;
         }
         return lists.get(0);
     }
     public ListNode merge_two_list(ListNode l1, ListNode l2){
         if(l1 == null) return l2;
         if(l2 == null) return l1;
         ListNode dummy = new ListNode(-1);
         ListNode p1 = l1, p2 = l2, p = dummy;
         while(p1 != null || p2 != null){
             if(p2 == null){
                 p.next = p1;
                 p1 = p1.next;
             }else if(p1 == null){
                 p.next = p2;
                 p2 = p2.next;
             }else{
                 if(p1.val <= p2.val){
                     p.next = p1;
                     p1 = p1.next;
                 }else{
                     p.next = p2;
                     p2 = p2.next;
                 }
             }
             p = p.next;
         }
         return dummy.next;
     }

     // solution2:
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

    public void merge(List<ListNode> lists){
      while(lists.size() > 1){
        List<ListNode> tmp = new ArrayList<>();
        for(int i = 0; i < lists.size() - 1; i += 2) {
          tmp.add(merge_two_list(lists.get(i), lists.get(i+1)));
        }
        lists = tmp;
      }
      return lists;
    }
    public void merge_two_list(ListNode l1, ListNode l2){
      if(l1 == null) return l2;
      if(l2 == null) return l1;
      ListNode dummy = new ListNode(-1);
      ListNode p1 = l1, p2 = l2, p = dummy;
      while(p1 != null || p2 != null){
        if(p2 == null){
          p.next = p1;
          p1 = p1.next;
        }else if(p1 == null){
          p.next = p2;
          p2 = p2.next;
        }else{
          if(p1.val <= p2.val){
            p.next = p1;
            p1 = p1.next;
          }else{
            p.next = p2;
            p2 = p2.next;
          }
        }
        p = p.next;
      }
      return dummy.next;
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
}
