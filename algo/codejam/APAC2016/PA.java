package teisei.algo.codejam.apac2016;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/7.
 */
public class PA {

    static Scanner sc;
    static Map<String, Integer> nameMap;
    static int map[][];
    static int M;
    static int inx;
    static boolean[] vst;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            init();
            printMap();
            System.out.println(isOk());
            printMap();

//            if(isOk())
//                System.out.println("Case #" + i + ": Yes");
//            else
//                System.out.println("Case #" + i + ": No");
        }
    }

    public static void init() {
//        System.out.println("init");
        inx = 0;
        nameMap = new HashMap<>();
        map = new int[20][20];
        M = sc.nextInt();

        sc.nextLine();


        for (int i = 0; i < M; i++) {
            String rec[] = sc.nextLine().split(" ");
            String name1 = rec[0];
            String name2 = rec[1];
            if (!nameMap.containsKey(name1)) nameMap.put(name1, inx++);
            if (!nameMap.containsKey(name2)) nameMap.put(name2, inx++);
            int id1 = nameMap.get(name1);
            int id2 = nameMap.get(name2);
            map[id1][id2] = 1;
            map[id2][id1] = 1;
        }
    }

    public static boolean isOk() {
//        System.out.println("run");
        for (int i = 0; i < inx; i++)
            for (int j = 0; j < inx; j++)
                map[i][j] = map[i][j] == 0 ? 1 : 0;

        vst = new boolean[inx];



        int res = 0;
        for (int i = 0; i < inx; i++) {
            if(!vst[i]){
                res++;
                dfs(i);
            }
        }
        System.out.println(res);

        return res < 3;
    }

    public static void dfs(int id) {
        if(!vst[id]){
            vst[id] = true;
            for (int i = 0; i < inx; i++) {
                if (id != i)
                    if(map[i][id]==1 && !vst[i])
                        dfs(i);
            }
        }
    }

    public static void printMap() {
        System.out.println("print");
        for (int i = 0; i < inx; i++) {
            for (int j = 0; j < inx; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
