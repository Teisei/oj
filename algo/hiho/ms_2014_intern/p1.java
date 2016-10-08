package teisei.algo.hiho.ms_2014_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/5.
 */
public class p1 {

    final static char c_init = '/';
    final static int i_0 = (int) '0';
    final static int i_9 = (int) '9';
    final static int i_a = (int) 'a';
    final static int i_z = (int) 'z';

    static Scanner sc = new Scanner(System.in);

    public static boolean isLegal(char x) {
        int i_x = (int) x;
        return ((i_x >= i_0 && i_x <= i_9) || (i_x >= i_a && i_x <= i_z));
    }

    public static String process(String line) {
        char[] array = line.toCharArray();
        Arrays.sort(array);

        List<Character> list = new ArrayList<>();
        for (char x : array) {
            list.add(x);
        }

        int len = array.length;
        String total_tmp = "";


        while (list.size() > 0) {
            int i = 0;
            String tmp = "";
            char max_x = c_init;
            for (; i < list.size(); i++) {
                char x = list.get(i);
                if (!isLegal(x)) return "<invalid input string>";

                if (max_x < x) {
                    max_x = x;
                    tmp += max_x;
                    list.remove(i);
                    i--;
                }
            }
            total_tmp += tmp;
        }
        return total_tmp;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String res = process(line);
            System.out.println(res);
        }
    }


    public static void test2() {
        String line = "";
        String res = process(line);
        System.out.println(res);
    }
}
