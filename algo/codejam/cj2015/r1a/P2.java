package teisei.algo.codejam.cj2015.r1a;

import teisei.algo.codejam.CodeJamTemplate;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P2 extends CodeJamTemplate {

    @Override
    public void init() {
        setDIR("./data/cj2015/r1a");
        setNAME("B");
        setTYPE("large");
        setLOCAL(System.getSecurityManager() == null);
    }


    @Override
    public void run() {
        int test = sc.nextInt();
        int B, N;
        long[] b;
        for (int t = 1; t <= test; t++) {
            B = sc.nextInt();
            N = sc.nextInt();


            b = new long[B];
            /*  time for every barber and the minimum one */
            long max_time = Integer.MIN_VALUE;
            for (int i = 0; i < B; i++){
                b[i] = sc.nextInt();
                max_time = Math.max(max_time, b[i]);
            }

            //when the n the customer can start getting hair cut
            //which number of barber will cut
            if (N == 1) {
                System.out.println("Case #" + t + ": " + getWhoIs1stAvailableForKthCustomer(0, b, N));
            } else {
                long startTime = 0, endTime = max_time * N / B + 5;

                long time = binarySearch(startTime, endTime, N, b);
//                System.out.println(startTime + "\t" + endTime + "\t" + time);

                long ready = N - howManyFinished(time, b) - howManyCutting(time, b);
                System.out.println("Case #" + t + ": " + getWhoIs1stAvailableForKthCustomer(time, b, ready));
            }
        }
    }

    private long binarySearch(long startTime, long endTime, int N, long[] b) {
        long midTime = (startTime + endTime) / 2;
        long finished = howManyFinished(midTime, b), cutting = howManyCutting(midTime, b);
        long ready = b.length - cutting;

        if (finished + cutting < N) {
            /* Nth not cutting or finished */
            if (finished + cutting + ready >= N) {
                return midTime;
            } else{
                return binarySearch(midTime + 1, endTime, N, b);
            }
        } else{
            /* Nth is cutting or finished */
            return binarySearch(startTime, midTime - 1, N, b);
        }

    }

    /**
     * get the first one who is available, at time t
     * if none, return -1
     */
    private long getWhoIs1stAvailableForKthCustomer(long time, long[] b, long k) {
        long inx = 0;
        for (int i = 0; i < b.length; i++) {
            if (time % b[i] == 0) {
                /* available */
                inx++;
            }
            if (inx == k) return i+1;
        }
        return -1;
    }

    /**
     * how many people down at time t
     */
    private long howManyFinished(long time, long[] b) {
        long num = 0;
        for (long bi : b) num += time / bi;
        return num;
    }

    private long howManyCutting(long time, long[] b) {
        long num = 0;
        for (long bi : b){
            num += time % bi == 0 ? 0 : 1;
        }
        return num;
    }

    public static void main(String[] args) {
        new P2().run0();
    }

}
