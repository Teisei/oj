package teisei.algo.lint.bigcompany.lv4;

/**
 * Created by Teisei on 2016/5/28.
 */
public class p_180 {
    public static void main(String[] args) {
        new p_180().run();
    }

    public void run() {
        String s = "3.5";
        System.out.println(binaryRepresentation(s));

    }

    /**
     * @param n: Given a decimal number that is passed in as a string
     * @return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        String res = "ERROR";
        String[] rec = n.split("\\.");
        if (rec.length == 1) {
            res = t1(rec[0]);
        } else if (rec.length == 2) {
            String s1 = t1(rec[0]);
            String s2 = t2(rec[1]);
            if (s2.equals("ERROR")) {
                return s2;
            } else {
                return s1 + "." + s2;
            }
        } else {

        }
        return res;
    }

    private String t1(String n) {
        int x = Integer.parseInt(n);
        String res = "";
        do {
            res = x % 2 + res;
            x /= 2;
        } while (x > 0);
        return res;
    }

    private String t2(String n) {
        String res = "";
        double x = Double.parseDouble("0." + n);
        double dividend = 1;
        int inx = 0;
        while (x > 0) {
            dividend *= 0.5;
            int t = (int) (x / dividend);
            res = t + res;
            inx++;
            if(inx>=32) return "ERROR";
            x -= t * dividend;
        }
        return res;
    }
}
