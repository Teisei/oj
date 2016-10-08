package teisei.algo.leetcode;

import java.util.Stack;

/**
 * Created by Teisei on 2016/5/28.
 */
public class p_331_VerifyPreorderSerializationofaBinaryTree {
    public static void main(String[] args) {
        new p_331_VerifyPreorderSerializationofaBinaryTree().run();
    }

    public void run() {
        String test = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(test));

    }

    public boolean isValidSerialization(String preorder) {

        Stack<Character> stack = new Stack<>();
        String[] ss = preorder.split(",");
        for (String s : ss) {
            char x = s.charAt(0);
            if (stack.isEmpty()) {
                stack.push(x);
            } else if (x != '#') {
                stack.push(x);
            } else {
                char top = stack.peek();
                while (top == '#') {
                    stack.pop();
                    if (stack.isEmpty()) return false;
                    stack.pop();
                    if(stack.isEmpty()) break;
                    top = stack.peek();
                }
                stack.push('#');
            }
        }
        if (stack.size() == 1) {
            if (stack.peek() == '#') {
                return true;
            }
        }
        return false;
    }
}
