package teisei.leetcode;

import java.util.Stack;

/**
 * Created by Teisei on 2016/3/3.
 */
public class p_20_ValidParentheses {
    public static void main(String[] args) {
        p_20_ValidParentheses test = new p_20_ValidParentheses();
        test.run();
    }

    public void run() {
        System.out.println(isValid("{[()]}"));
        System.out.println(isValid("[])"));

    }
    public boolean isValid(String s) {
        if (s.length() == 1) return false;
        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '}' || ch == ']' || ch == ')') {
                if(stk.isEmpty()) return false;
                char ch1 = stk.peek();
                if (isValid(ch1, ch)) {
                    stk.pop();
                } else {
                    return false;
                }

            } else {
                stk.push(ch);
            }
        }
        return stk.empty();
    }

    public boolean isValid(char l, char r) {
        if (l == '(' && r == ')') return true;
        if (l == '[' && r == ']') return true;
        if (l == '{' && r == '}') return true;
        return false;
    }
}
