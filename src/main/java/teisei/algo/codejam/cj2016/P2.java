package teisei.algo.codejam.cj2016;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/9.
 */
public class P2 {
    static boolean LOCAL = System.getSecurityManager() == null;
    static Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {
        new P2().run0();
    }

    public void run0() {

        if (LOCAL) {
            try {
                String inputPath = "D:\\Download\\B-large.in";
//                inputPath = "./data/in2.txt";
                System.setIn(new FileInputStream(inputPath));
                sc = new Scanner(System.in);

//                String outputPath = "D:\\IntelliJ_Projects\\oj\\src\\main\\java\\teisei\\algo\\codejam\\cj2016\\B-large.out";
//                System.setOut(new PrintStream(new FileOutputStream(outputPath)));

            } catch (Exception e) {
                e.printStackTrace();
                LOCAL = false;
            }
        }
        new P2().run();
    }

    public void run3() {
        String str = "--+-";
        char[] chs = normal(str.toCharArray());
        for (char ch : chs) {
            System.out.println(ch);
        }
    }


    public void run() {
        int test = sc.nextInt();
        sc.nextLine();

        for(int i=1;i<=test;i++) {
            String line = sc.nextLine();
            line = line.trim();
            int res = 0;
            if (!line.equals("")) {
                res = normal(line.toCharArray()).length;
            }
            System.out.println("Case #" + i + ": " + res);
        }
    }

    public char[] normal(char[] arr) {
        int end = arr.length - 1;
        while (arr[end] == '+') {
            end--;
            if(end<0) break;
        }
        List<Character> list = new ArrayList<>();
        char pre_ch = '0';
        for(int i = 0;i<=end;i++){
            if(arr[i]!=pre_ch){
                list.add(arr[i]);
                pre_ch = arr[i];
            }
        }
        int inx = 0;
        char[] chs = new char[list.size()];
        for (char ch : list) {
            chs[inx++] = ch;
        }
        return chs;
    }

}
