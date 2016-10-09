public class P_124 {
    /**
      Constraint:
      1) unsorted array, 0<= length
      2) element: INT_MIN <= X <= INT_MAX
      3) LCA(longest continous array), is a subarray with continous elements
      4) return the length of LCA

      test:
      [] => 0
      [-1, 1,2,3, 6,7] => 3
      [100, 4, 200, 1, 3, 2] => 4

      idea:
      1) sort the array
      max_length = 0
      keep a current number x, current length l,
      if the right number if x + 1,
        x ++;l ++;
      else
        max_length = max(l, max_length)
        x = current; l = 1
      time: O(n log n)
      space: O(1)

      2) use hashtable to check if a number has a neighbor
      check for every number, and exetend boundary if it has neighbor
      time: O(n * n)
      avoid access number twice: is access label it
      time: O(n)
      space: O(n)

     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if(num == null || num.length == 0) return 0;

        // hashtable
        Set<Integer> hash = new HashSet<>();
        for(int x: num){
          if(!hash.contains(x)) hash.add(x);
        }

        int max_length = 0;
        for(int x: num){
          int left = x, right = x - 1;
          // exetend to right boundary
          while(hash.contains(right + 1)){
            right ++;
            hash.remove(right);
          }
          // exetend to left boundary
          while(hash.contains(left - 1)){
            left --;
            hash.remove(left);
          }
          int length = right - left + 1;
          max_length = length > max_length ? length : max_length;
        }
        return max_length;
    }
}
