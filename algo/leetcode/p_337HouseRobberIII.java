package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/4/20.
 */
public class p_337HouseRobberIII {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new p_337HouseRobberIII().run();
    }


    public void run() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
//
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
//
        root.right.right = new TreeNode(1);

        System.out.println(rob(null));

    }


    public int rob(TreeNode root) {
        traverse(root);
        return root.val;
    }

    public void traverse(TreeNode node) {
        if(node==null) return;

        // hou xu bian li
        int v_childs = 0, v_grands = 0;
        if (node.left != null) {
            traverse(node.left);
            v_childs += node.left.val;
            if (node.left.left != null)
                v_grands += node.left.left.val;
            if (node.left.right != null)
                v_grands += node.left.right.val;
        }
        if (node.right != null) {
            traverse(node.right);
            v_childs += node.right.val;
            if (node.right.left != null)
                v_grands += node.right.left.val;
            if (node.right.right != null)
                v_grands += node.right.right.val;
        }
        node.val = Math.max(v_childs, v_grands + node.val);
    }

    public int rob1(TreeNode root) {
        return dfs(root)[0];
    }

    private int[] dfs(TreeNode root) {
        int rob[] = {0, 0};
        if (root != null) {
            int[] robLeft = dfs(root.left);
            int[] robRight = dfs(root.right);
            rob[1] = robLeft[0] + robRight[0];//上一波最大值
            rob[0] = Math.max(rob[1], robLeft[1] + robRight[1] + root.val);//上一波的上一波，和本波
        }
        return rob;
    }
}
