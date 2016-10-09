package teisei.algo.hiho.mstest2015oct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/5.
 */
class P2Node {
    String name;
    int start;
    int end;
    String type;
    List<P2Node> children;

    public P2Node(String name, int start, String type) {
        this.name = name;
        this.start = start;
        this.type = type;
        children = new ArrayList<>();
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return name + " " + (end-start);
    }

}

public class p2 {
    static Scanner sc = new Scanner(System.in);
    static P2Node[] stack = new P2Node[20010];
    static int inx = 0;
    static int[] index = new int[20010];
    static P2Node[] resnodes = new P2Node[60*60*60];


    public static void main(String[] args) {
        run();
    }
//
//    public static void test() {
//        int n = 8;
//        String str[] = new String[]{
//                "FuncA 00:00:01 START",
//                "FuncB 00:00:02 START",
//                "FuncC 00:00:03 START",
//                "FuncC 00:00:04 END",
//                "FuncB 00:00:05 END",
//                "FuncD 00:00:06 START",
//                "FuncD 00:00:07 END",
//                "FuncA 00:00:08 END"
//        };
//
//        Stack<P2Node> finish = new Stack<>();
//
//        int global_timestamp = 0;
//
//        boolean flag = true;
//        int i, i_peak = -1;
//        for (i = 0; i < n; i++) {
//            String line = str[i];
//
//            /* new a node and*/
//            String rec[] = line.split(" ");
//            String name = rec[0];
//            String timestamp = rec[1];
//            if (getTimestampInt(timestamp) <= global_timestamp) {
//                flag = false;
//                break;
//            }
//            global_timestamp = getTimestampInt(timestamp);
//
//            boolean type = rec[2].equals("START") ? true : false;
//            P2Node curNode = new P2Node(name, timestamp, type);
//
//            /*  if it is start */
//            if (curNode.type) {
//                stack[++i_peak] = curNode;
//                index[inx++] = getTimestampInt(curNode.timestamp);
//            } else {
//                if (i_peak == -1) {
//                    flag = false;
//                    break;
//                }
//                P2Node peakNode = stack[i_peak];
//                /* make sure added later, equal name, start type*/
//                if (peakNode.timestamp.compareTo(curNode.timestamp) > 0 || !peakNode.name.equals(curNode.name) || !peakNode.type) {
//                    flag = false;
//                    break;
//                }
//                int timeVal = getTimestampInt(curNode.timestamp) - getTimestampInt(peakNode.timestamp);
//
//                /*  store the results */
//                int start_time = getTimestampInt(peakNode.timestamp);
//                resnodes[start_time] = new P2Node(curNode.name, getTimestampStr(timeVal), false);
//                i_peak--;
//            }
//        }
//        flag = flag && i == n;
//        if (!flag) {
//            System.out.println("Incorrect performance log");
//        } else {
//            for(i=0;i<inx;i++) {
//                System.out.println(resnodes[index[i]]);
//            }
//        }
//    }


    public static void run() {
        int n = sc.nextInt();
        sc.nextLine();

        int i, i_peak = -1,global_timestamp=-1;
        P2Node root = null;

        for (i = 0; i < n; i++) {
            String line = sc.nextLine();
             /* new a node and*/
            String rec[] = line.split(" ");
            String name = rec[0];
            int timestamp = getTimestampInt(rec[1]);

            /*  if time  */
            if (timestamp < global_timestamp) {
                System.out.println("Incorrect performance log");
                return;
            }

            /**  creat the current node */
            String type = rec[2];

            P2Node parent;
            P2Node curNode = new P2Node(name, timestamp, type);

            /*  if it is start */
            if (type.equals("START")) {
                if (i_peak == -1) {
                    if (i == 0) {
                        stack[++i_peak] = curNode;
                    } else {
                        System.out.println(i_peak + "\t" + i);
                        System.out.println("Incorrect performance log");
                        return;
                    }
                } else {
                    parent = stack[i_peak];
                    if (parent.name.equals(curNode.name)) {
                        System.out.println("Incorrect performance log");
                        return;
                    } else {
                        parent.children.add(curNode);
                        stack[++i_peak] = curNode;
                    }
                }
            } else if (type.equals("END")) {
                /*  if the stack is empty */
                if (i_peak == -1) {
                    System.out.println("Incorrect performance log 444");
                    return;
                } else {
                    /** element in the top of the stack */
                    parent = stack[i_peak];
                    root = parent;
                    if (parent.name.equals(curNode.name)) {
                        if (timestamp < parent.start) {
                            System.out.println("Incorrect performance log");
                            return;
                        }
                        parent.setEnd(timestamp);
                        i_peak--;
                    } else {
                        System.out.println("Incorrect performance log");
                        return;
                    }
                }

            } else {
                System.out.println("Incorrect performance log");
                return;
            }
            global_timestamp = timestamp;
        }
        if (i_peak!=-1) {
            System.out.println("Incorrect performance log");
        } else {
            dfs(root);
        }
    }

    public static void dfs(P2Node root){
        if(root == null)
            return ;
        System.out.println(root.name + " " + getTimestampStr(root.end - root.start));
        for (P2Node child : root.children) {
            dfs(child);
        }
    }

    public static int getTimestampInt(String date) {
        String rec[] = date.split(":");
        int value = Integer.parseInt(rec[0]) * 60 * 60 + Integer.parseInt(rec[1]) * 60 + Integer.parseInt(rec[2]);
        return value;
    }
    public static String getTimestampStr(int date) {
        String value = "";
        value += getIntStr(date/3600)+":";date = date % 3600;
        value += getIntStr(date/60)+":";date = date % 60;
        value += getIntStr(date);
        return value;
    }

    public static String getIntStr(int a){
        if(a<10) return "0" + a;
        else return "" + a;
    }


}
