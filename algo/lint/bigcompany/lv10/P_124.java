public class P_124 {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        HashSet<Integer> lookup = new HashSet<Integer>();
        for(int x: num){
            lookup.add(x);
        }

        int max = 0;

        // scan the num
        for(int x: num){

            // if this element is visited, skip
            if(!lookup.contains(x)) continue;

            int count = 1;
            int left = x - 1, right = x + 1;
            while(lookup.contains(left)){
                count++;
                lookup.remove(left--);
            }

            while(lookup.contains(right)){
                count++;
                lookup.remove(right++);
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
