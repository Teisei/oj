package teisei.algo.hiho.mstest2015oct;

import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/5.
 */
class Node{
    char ch;
    int count;

    public Node(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }

    public void addCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return "{" + ch + ", " + count + '}';
    }

}
public class p1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    public static void test() {
        String str[] = new String[]{
                "abc",
                "cde",
                "aabbcc",
                "aaabbbccc",
                "abd",
                "cba",
                "aabbc",
                "zab",
        };
        for (String e : str) {
            System.out.println(isBeautifulString(e));
        }
    }

    public static void run() {
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            String line = sc.next();
            if (isBeautifulString(line)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }


    public static boolean isBeautifulString(String str){
        char[] x = str.toCharArray();
        if(x.length<3) return false;

        Node nodes[] = new Node[x.length];

        int inx = 0, i=0;
        char cur = x[i++];
        nodes[inx] = new Node(cur, 1);
        while (i < x.length) {
            if (x[i] == cur) {
                nodes[inx].addCount();
            } else {
                cur = x[i];
                nodes[++inx] = new Node(cur, 1);
            }
            i++;
        }

        for(i=0;i<=inx-2;i++) {
            if (isOK(nodes[i], nodes[i + 1], nodes[i + 2])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOK(Node a, Node b, Node c) {
        if (a.ch == b.ch - 1 && b.ch == c.ch - 1) {
            return a.count>=b.count && c.count>=b.count;
        }
        return false;
    }
}
