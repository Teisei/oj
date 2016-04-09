package teisei.algo.codejam.cj2016;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P3 {
    static boolean LOCAL = System.getSecurityManager() == null;
    static Scanner sc = new Scanner(System.in);
    static Set<Long> prime = new HashSet<>();


    public void run1() throws FileNotFoundException {
        System.out.println("100011 5 13 147 31 43 1121 73 77 629");
        loadPrime();
        String a_str = "1001";
        System.out.println(getNBasedX(a_str, 9));
        List<Long> divisors = getDivisors(getNBasedX(a_str, 2));
        for (long e : divisors) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new P3().run0();
    }

    public void loadPrime() throws FileNotFoundException {
        String inputPath = "./data/prime.txt";
        System.setIn(new FileInputStream(inputPath));
        sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            prime.add(sc.nextLong());
        }
    }

    public void run0() throws FileNotFoundException {

        P3 test = new P3();
        test.loadPrime();

        if (LOCAL) {
            try {
                String inputPath = "D:\\Download\\C-large.in";
//                inputPath = "./data/in2.txt";
                System.setIn(new FileInputStream(inputPath));
                sc = new Scanner(System.in);

                String outputPath = "D:\\IntelliJ_Projects\\oj\\src\\main\\java\\teisei\\algo\\codejam\\cj2016\\C-large.out";
                System.setOut(new PrintStream(new FileOutputStream(outputPath)));

            } catch (Exception e) {
                e.printStackTrace();
                LOCAL = false;
            }
        }
        test.process();
    }


    public void process() {
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {

            /**   test */
            int digit = sc.nextInt();
            int num = sc.nextInt();
            System.out.println("Case #" + i + ":");

            /*  get the first number */
            String str_min = "1", str_max = "1";
            for (int j = 0; j < digit - 2; j ++) {

                str_min += "0";
                str_max += "1";
            }
            str_min += "1";
            str_max += "1";

            long a_min = getNBasedX(str_min, 2), a_max = getNBasedX(str_max, 2);

            int inx = 0, res_num = 0;

            while (a_min + inx <= a_max && res_num < num) {

                long a = a_min + inx;

                /** check this number */
                List<Long> divisors = getDivisors(a);

                if (divisors != null) {
                    res_num++;
                    System.out.println(formatResult(a, divisors));
                }
                inx += 2;
            }

        }
    }


    /**
     * get all the nontrivial divisor for jamcoin based 2-10
     *
     * @param a
     * @return
     */
    public List<Long> getDivisors(long a) {
        List<Long> resList = new ArrayList<>();

        String a_str = getXBasedN(a, 2);

        /* supposed that all not prime */
        boolean allNotPrime = true;

        for (int k = 2; k <= 10; k++) {

            long a_k = getNBasedX(a_str, k);

            /** check whether a_k is a prime */
            if (prime.contains(a_k)) {
                allNotPrime = false;
                break;
            }
        }

        if (allNotPrime) {
            /** from base 2 to base 10*/
            for (int k = 2; k <= 10; k++) {
                long a_k = getNBasedX(a_str, k);
//                System.out.println(a_k);
                long divisor = 1;

                /** check a divisor */
                for (long t : prime) {
                    if (a_k % t == 0) {
                        divisor = t;
                        break;
                    }
                }
                if (divisor == 1) return null;
                resList.add(divisor);

            }
        }
        return (!allNotPrime) ? null : resList;
    }

    public String formatResult(long a, List<Long> divisors) {
        String a_str = getXBasedN(a, 2);
        String res = a_str;
        for (long e : divisors) {
            res += " " + e;
        }
        return res;
    }


    /**   */
    public String getXBasedN(long N, int x) {
        String tmp = "";
        while (N > 0) {
            long remainder = N % x;
            tmp = "" + remainder + tmp;
            N /= x;
        }
        return tmp;
    }


    /**   */
    public long getNBasedX(String str, int x) {
        return getNBasedX(str.toCharArray(), x);
    }

    /**   */
    public long getNBasedX(char[] arr, int x) {
        long res = 0;
        long base = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            res += (arr[i] == '1' ? 1 : 0) * base;
            base *= x;
        }
        return res;
    }


}
