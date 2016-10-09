package teisei.algo.leetcode;

/**
 * Created by Teisei on 2016/5/28.
 */
public class p_155_MinStack {
    public static void main(String[] args) {
        new p_155_MinStack().run();
    }

    public void run() {
        MinStack minStack  = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
class MinStack {

    final int MAX_NUM = 1024;
    int[] stack;
    int inx;
    int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new int[MAX_NUM];
        inx = -1;
    }

    public void push(int x) {
        if (!isFull()) {
            min = Math.min(min, x);
            stack[++inx] = x;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            int x = stack[inx];
            inx--;
            min = computeMin();
        }
    }

    public int top() {
        if (!isEmpty()) {
            return stack[inx];
        }
        return 0;
    }

    public int getMin() {
        return min;
    }

    private int computeMin() {
        int min = Integer.MAX_VALUE;
        if (!isEmpty()) {
            for (int i = 0; i <= inx; i++) {
                min = Math.min(min, stack[i]);
            }
        }
        return min;
    }

    private boolean isEmpty() {
        return inx < 0;
    }

    private boolean isFull() {
        return inx >= MAX_NUM - 1;
    }
}
