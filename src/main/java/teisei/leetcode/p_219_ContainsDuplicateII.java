package teisei.leetcode;

import java.util.*;

/**
 * Created by Teisei on 2016/3/11.
 */
public class p_219_ContainsDuplicateII {
    public static void main(String[] args) {
        p_219_ContainsDuplicateII test = new p_219_ContainsDuplicateII();
        test.run();

    }

    public void run() {
        int[] nums = new int[]{1, 2, 1};
        System.out.println(containsNearbyDuplicate(nums, 0));
    }
    class Node{
        int inx;
        Node left, right;

        public Node(int inx) {
            this.inx = inx;
        }
    }

    public boolean insertChildren(Node node, int inx, int k) {
        if(Math.abs(node.inx-inx)<=k) return true;
        if (inx < node.inx) {
            if (node.left == null) {
                node.left = new Node(inx);
                return false;
            } else {
                return insertChildren(node.left, inx, k);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(inx);
                return false;
            } else {
                return insertChildren(node.right, inx, k);
            }
        }
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Node> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int e = nums[i];
            if (!map.containsKey(e)) {
                map.put(e, new Node(i));
            } else {
                if(insertChildren(map.get(e), i, k)) return true;
            }

        }
        return false;
    }
}
