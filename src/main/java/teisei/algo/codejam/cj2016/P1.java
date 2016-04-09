package teisei.algo.codejam.cj2016;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P1 {
    static boolean LOCAL = System.getSecurityManager() == null;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        if (LOCAL) {
            try {
                System.setIn(new FileInputStream("./data/in1.txt"));
                System.setOut(new PrintStream(new FileOutputStream("D:\\IntelliJ_Projects\\oj\\src\\main\\java\\teisei\\algo\\codejam\\cj2016\\out.txt")));

            } catch (Throwable throwable) {
                LOCAL = false;
            }

        }
        new P1().run();

    }

    public void run() {
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            int N = sc.nextInt();
            int res = getN(N);
            if (res > 0) {
                System.out.println("Case #" + i + ": " + res);
            } else {
                System.out.println("Case #" + i + ": INSOMNIA");
            }
        }
    }

    public int getN(int N) {
        int inx = 1;
        Map<Integer, Integer> map = new HashMap<>();
        while (map.size() < 10 && inx < 1000000) {
            int rest = N * inx;
            while (rest > 0) {
                int remainder = rest % 10;
                if (!map.containsKey(remainder)) map.put(remainder, 1);
                rest /= 10;
            }
            if(map.size()==10) break;
            inx++;
        }
        return map.size() == 10 ? N * inx : -1;
    }






}
