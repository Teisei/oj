package teisei.algo.codejam.cj2016.r1c;

import teisei.algo.codejam.CodeJamTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Teisei on 2016/4/16.
 */
public class Pa extends CodeJamTemplate {
    public static void main(String[] args) {
        new Pa().run0();

    }

    @Override
    public void run() {
        int test = sc.nextInt();
        sc.nextLine();
        for (int t = 1; t <= test; t++) {
            String str = sc.nextLine();
            System.out.println("Case #" + t + ": " + getTheOne(str));
        }
    }

    private String getTheOne(String str) {
        long start = System.currentTimeMillis();
        if (str.length() == 1) return str;
        List<String> list = new ArrayList<>();
        list.add("" + str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            List<String> tmpList = new ArrayList<>();
            for (String e : list) {
                tmpList.add(e + str.charAt(i));
                tmpList.add(str.charAt(i) + e);
            }
            list = tmpList;
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.compareTo(o2)<0) return 1;
                else if(o1.compareTo(o2)==0) return 0;
                else return -1;
            }
        });
//        System.out.println("time: " + (System.currentTimeMillis() - start));
        return list.get(0);
    }

    @Override
    public void init() {
        setDIR("./data/cj2016/r1c");
        setNAME("A");
        setTYPE("small");
//        setLOCAL(System.getSecurityManager() == null);
        setLOCAL(true);
    }
}
