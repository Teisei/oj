package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/3/1.
 */
public class p_104_MaximumDepthOfBinaryTree {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        p_104_MaximumDepthOfBinaryTree test = new p_104_MaximumDepthOfBinaryTree();
        test.run();
    }

    public void run() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        return root==null?0:maxD(root);
    }
    public int maxD(TreeNode x){
        return x == null ? 0 : Math.max(maxD(x.left) + 1, maxD(x.right) + 1);
    }
}
