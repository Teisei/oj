package teisei.leetcode;

/**
 * Created by Teisei on 2016/3/1.
 */
public class p_226_InvertBinaryTree {
    /**
     * Definition of a binary tree node
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
        p_226_InvertBinaryTree test = new p_226_InvertBinaryTree();
        test.run();
    }

    public void run() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        TreeNode l = root.left;
        l.left = new TreeNode(1);
        l.right = new TreeNode(3);
        TreeNode r = root.right;
        r.left = new TreeNode(6);
        r.right = new TreeNode(9);
        printTree(root);
        invertTree(root);
        System.out.println("==================");
        printTree(root);

    }

    public TreeNode invertTree(TreeNode root) {
        inverT(root);
        return root;
    }

    public void inverT(TreeNode x) {
        if(x == null) return;
        invertTree(x.left);
        invertTree(x.right);
        op(x);
    }

    public void op(TreeNode x) {
        if(x == null) return;
        if (x.left != null && x.right != null) {
            TreeNode tmp = x.left;
            x.left = x.right;
            x.right = tmp;
        } else if (x.left != null) {
            x.right = x.left;
            x.left = null;
        } else if (x.right != null) {
            x.left = x.right;
            x.right = null;
        }
    }

    public void printTree(TreeNode x) {
        if(x==null) return;
        System.out.println(x.val);
        printTree(x.left);
        printTree(x.right);
    }
}
