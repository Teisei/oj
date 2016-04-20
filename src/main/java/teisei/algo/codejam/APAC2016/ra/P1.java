package teisei.algo.codejam.apac2016.ra;

import teisei.algo.codejam.CodeJamTemplate;

import java.util.*;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P1 extends CodeJamTemplate {

    @Override
    public void init() {
        setDIR("./data/apac2016/ra");
        setNAME("A");
        setTYPE("large");
//        setLOCAL(System.getSecurityManager() == null);
        setLOCAL(true);
    }


    @Override
    public void run() {
        int test = sc.nextInt();
        for(int t = 1;t<=test;t++) {
            long N = sc.nextLong();
            long round = getRound(N);
            System.out.println("Case #" + t + ": "+ round);
        }
    }

    private long getRound(long N) {

        PriorityQueue<Long> queue = new PriorityQueue<>(1000000);
        Map<Long, Long> roundMap = new HashMap<>();
        long distance = N;

        queue.add(distance);
        long round = 0;
        roundMap.put(distance, round);

        while (true) {
            round++;
            List<Long> list = new ArrayList<>();
//            System.out.println(queue.size());
            System.out.println("#round " + round + "\t" + (N - queue.peek()) +"\tqueue size = " +queue.size());
            while (!queue.isEmpty()) {
                long dis = queue.poll();

                long number = N - dis;//

                long w1 = reverse(number);
                if (w1 > 0 && w1 <= N) {

                    long dis1 = N - w1;
                    if (dis1 == 0) return round;
                    if (dis1 > 0 && !roundMap.containsKey(dis1)) {
                        roundMap.put(dis1, round);
                        list.add(dis1);
                    }
                }

                long w2 = number + 1;
                long dis2 = N - w2;
                if(dis2 == 0) return round;
                if (dis2>0 && !roundMap.containsKey(dis2)) {
                    roundMap.put(dis2, round);
                    list.add(dis2);
                }
            }
            assert queue.isEmpty() == true;
//            System.out.println("round "+round);
//            System.out.println("list size =  "+list.size());
            for (long e : list) {
//                System.out.println(e);
//                System.out.print(e+"\t");
                queue.add(e);
            }
//            System.out.println();
        }
    }

    private long reverse1(long x) {
        String x_str = "" + x;
        String tmp = "";
            for (int i = x_str.length()-1; i >=0; i--) {
                tmp += x_str.charAt(i);
            }
            return Long.parseLong(tmp);
    }
    private long reverse2(long x) {
        String x_str = "" + x;
        String tmp = "";
        if (x_str.charAt(0) < x_str.charAt(x_str.length() - 1)) {
            for (int i = x_str.length()-1; i >=0; i--) {
                tmp += x_str.charAt(i);
            }
            return Long.parseLong(tmp);
        }
        return -1;
    }

    private long reverse(long x) {
        return reverse1(x);
    }

    public static void main(String[] args) {
        new P1().run0();

    }

    public void test() {
        System.out.println(reverse1(123000));
        System.out.println(reverse(654321));

    }
}
