package teisei.algo.codejam.cj2016.r1c;

import teisei.algo.codejam.CodeJamTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Teisei on 2016/4/16.
 */
public class Pc extends CodeJamTemplate {
    public static void main(String[] args) {
        new Pc().run0();

    }

    @Override
    public void run() {
        int test = sc.nextInt();
        sc.nextLine();
        for (int t = 1; t <= test; t++) {
            Map<String, Integer> map = new HashMap<>();
            int J = sc.nextInt();
            int P = sc.nextInt();
            int S = sc.nextInt();
            int K = sc.nextInt();

            List<String> list1 = new ArrayList<>();

            for (int i = 1; i <= J; i++) {
                for (int j = 1; j <= P; j++) {
                    list1.add("" + i + "" + j);
                }
            }
            List<String> res = new ArrayList<>();
            for (int i = 1; i <= S; i++) {
                for (String e : list1) {
                    String tmp = e + "" + i;
                    String e1 = "X" + tmp.charAt(1) + tmp.charAt(2);
                    String e2 = tmp.charAt(0) + "X" + tmp.charAt(2);
                    String e3 = tmp.charAt(0) + tmp.charAt(1) + "X";

                    if (map.containsKey(e1))
                        if (map.get(e1) >= K)
                            continue;

                    if (map.containsKey(e2))
                        if (map.get(e2) >= K)
                            continue;

                    if (map.containsKey(e3))
                        if (map.get(e3) >= K)
                            continue;

                    res.add(tmp);

                    if (!map.containsKey(e1)) map.put(e1, 0);
                    if (!map.containsKey(e2)) map.put(e2, 0);
                    if (!map.containsKey(e3)) map.put(e3, 0);


                    map.put(e1, map.get(e1) + 1);
                    map.put(e2, map.get(e2) + 1);
                    map.put(e3, map.get(e3) + 1);
                }

            }
            System.out.println("Case #" + t + ": " + res.size());
            for (String e : res) {
                String tmp = "";
                tmp += e.charAt(0) + " " + e.charAt(1) + " " + e.charAt(2);
                System.out.println(tmp);
            }
        }
    }


    @Override
    public void init() {
        setDIR("./data/cj2016/r1c");
        setNAME("C");
        setTYPE("small-attempt4");
//        setLOCAL(System.getSecurityManager() == null);
        setLOCAL(true);
    }
}
