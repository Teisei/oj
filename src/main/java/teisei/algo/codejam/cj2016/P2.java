package teisei.algo.codejam.cj2016;

import teisei.algo.codejam.CodeJamTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P2 extends CodeJamTemplate {

    @Override
    public void init() {
        setDIR("./data/cj2016");
        setNAME("B");
        setTYPE("test");
        setLOCAL(System.getSecurityManager() == null);
    }


    public static void main(String[] args) {
        new P2().run0();
    }

    public void run() {
        int test = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= test; i++) {
            String line = sc.nextLine();
            line = line.trim();
            int res = 0;
            if (!line.equals("")) {
                res = normal(line.toCharArray()).length;
            }
            System.out.println("Case #" + i + ": " + res);
        }
    }

    public char[] normal(char[] arr) {
        int end = arr.length - 1;
        while (arr[end] == '+') {
            end--;
            if (end < 0) break;
        }
        List<Character> list = new ArrayList<>();
        char pre_ch = '0';
        for (int i = 0; i <= end; i++) {
            if (arr[i] != pre_ch) {
                list.add(arr[i]);
                pre_ch = arr[i];
            }
        }
        int inx = 0;
        char[] chs = new char[list.size()];
        for (char ch : list) {
            chs[inx++] = ch;
        }
        return chs;
    }

}
