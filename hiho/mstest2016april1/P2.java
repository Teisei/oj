package teisei.algo.hiho.mstest2016april1;

import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/6.
 */
class HahaNode{
    int digit;
    HahaNode left, right;
    int status;//-1, 0, 1

    public HahaNode(int digit) {
        this.digit = digit;
    }
}
public class P2 {
    static HahaNode root;
    static int N, M;

    static int getInteger(String id) {
        String rec[] = id.split("\\.");
        int sum = 0;
        sum+=Integer.parseInt(rec[0])*256*256*256;
        sum+=Integer.parseInt(rec[1])*256*256;
        sum+=Integer.parseInt(rec[2])*256;
        sum+=Integer.parseInt(rec[3])*256;
        return sum;
    }

    static void buildTree() {
        root = new HahaNode(0);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<N;i++) {
            String line = sc.nextLine();
            String type = line.split(" ")[0];

            int status = 0;
            if(type.equals("allow")) status = 1;
            if(type.equals("deny")) status = -1;

            String rec[] = line.split(" ")[1].split("/");

            int id = getInteger(rec[0]);
            System.out.println(id);
            int mask = 32;
            if(rec.length>1) mask = Integer.parseInt(rec[1]);

            insertNode(root, id, status, mask);

        }
    }

    static void insertNode(HahaNode root, int id, int status, int mask) {
        HahaNode p = root;
        int x = id;
        int i=0;
        mask--;
        while (i<32) {
            int tt = x & 1 << i++;
            x -= tt;
            tt = tt > 0 ? 1 : 0;
            if (tt==0) {
                if(p.left==null){
                    p.left = new HahaNode(tt);
                }
                p = p.left;
            } else {
                if(p.right==null){
                    p.right = new HahaNode(tt);
                }
                p = p.right;
            }
            if(i==mask){
                p.status = status;
                System.out.println("i = " + i + " p.status= " + p.status);
                return;
            }
            if(p==null) return;
        }
    }

    static boolean getStatus(int x){
        HahaNode p = root;
        int mark = 1 << 31;
        //huode ith digit
        int i=0;
        while (true) {
            int tt = x & 1 << i++;
            if (tt==0) {
                p = p.left;
            } else {
                p = p.right;
            }
            if(p==null) return true;
            if(p.status==-1) return false;
            if(p.status==1) return true;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void search() {
        for(int i=0;i<M;i++) {
            int id = getInteger(sc.nextLine());
            if(getStatus(id)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static void run() {
        buildTree();
        search();
    }

    public static void main(String[] args) {
        run();
    }

    public static void test() {

    }
}
