package teisei.algo.codejam.cj2016;

import teisei.algo.codejam.CodeJamTemplate;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P3 extends CodeJamTemplate {


    @Override
    public void init() {
        setDIR("./data/cj2016");
        setNAME("C");
        setTYPE("test");
        setLOCAL(System.getSecurityManager() == null);
    }


    static Set<BigInteger> prime;
    /**
     * compute the all the prime less than 10000
     */
    public void loadPrime() {
        prime = new HashSet<>();
        for (int i = 3; i < 10000; i += 2) {
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) continue;
            }
            prime.add(BigInteger.valueOf(i));
        }
    }


    public static void main(String[] args) {
        P3 test = new P3();

        test.loadPrime();
        test.run0();

    }


    public void run() {
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {

            /**   test */
            int N = sc.nextInt();
            int J = sc.nextInt();
            System.out.println("Case #" + t + ":");

            /*  get the first number */
            StringBuilder sb = new StringBuilder();
            sb.append('1');
            for (int i = 1; i < N - 1; i++) {
                sb.append('0');
            }
            sb.append('1');

            Random r = new Random(12345);

            int inx = 0;

            /** find J candidates */
            while (inx < J) {
                for (int i = 1; i < N - 1; i++)
                    sb.setCharAt(i, r.nextInt(2) > 0 ? '1' : '0');
                String a_str = sb.toString();
                List<BigInteger> list = getDivisors(a_str);
                if (list != null) {
                    for (BigInteger divisor : list) {
                        a_str += " " + divisor;
                    }
                    System.out.println(a_str);
                    inx++;
                }

            }
        }
    }


    /**
     * get all the nontrivial divisor for jamcoin based 2-10
     */
    public List<BigInteger> getDivisors(String a_str) {
        List<BigInteger> resList = new ArrayList<>();

        /* supposed that all not prime */
        boolean allNotPrime = true;

        int k = 2;

        /** check whether a_k is a prime in any base from 2 to 10 */
        for (; k <= 10; k++) {
            BigInteger a_k = new BigInteger(a_str, k);
            if (prime.contains(a_k)) {
                allNotPrime = false;
                break;
            }
        }

        if (allNotPrime) {
            /** from base 2 to base 10*/
            cycle:
            for (k = 2; k <= 10; k++) {
                BigInteger a_k = new BigInteger(a_str, k);
                for (BigInteger divisor : prime) {
                    if (a_k.mod(divisor).equals(BigInteger.ZERO)) {
                        resList.add(divisor);
                        continue cycle;
                    }
                }
                break;
            }
        }
        return (!allNotPrime || k < 11) ? null : resList;
    }
}
