package teisei.leetcode;

import java.util.*;

/**
 * Created by Teisei on 2016/3/10.
 */
public class p_210_CourseScheduleII {
    public static void main(String[] args) {
        p_210_CourseScheduleII test = new p_210_CourseScheduleII();
        test.run();
    }

    public void run() {
        int n = 4;
        int[][] rs = new int[][]{
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        };
        n = 10;
        rs = new int[][]{
                {5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}
        };

        for (int x : findOrder1(n, rs)) {
            System.out.print(x + "->");
        }
        System.out.println();
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inMap = new HashMap<>();
        boolean[][] map = new boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) inMap.put(i, 0);

        for(int i=0;i<prerequisites.length;i++) {
            int task = prerequisites[i][0], pre = prerequisites[i][1];
            if (!map[pre][task]) {
                inMap.put(task, inMap.get(task) + 1);
                map[pre][task] = true;
            }
        }
        boolean flag = true;
        int[] res = new int[numCourses];
        int inx = 0;
        while (!inMap.isEmpty()) {
            int from = -1;
            for (int k : inMap.keySet()) {
                if (inMap.get(k) == 0) {
                    from = k;
                    break;
                }
            }
            if (from < 0) {
                flag = false;
                break;
            }

            res[inx++] = from;
            inMap.remove(from);
            for(int j=0;j<numCourses;j++) {
                if (map[from][j]) {
                    map[from][j] = false;
                    inMap.put(j, inMap.get(j) - 1);
                }
            }
        }
        return flag ? res : new int[0];
    }

    class Node{
        int id;
        int in, out;
        Set<Integer> ins;
        Set<Integer> outs;

        public Node(int id) {
            this.id = id;
            outs = new HashSet<>();
            ins = new HashSet<>();
        }

        public void addOut(int to) {
            if (!outs.contains(to)) {
                out++;
                outs.add(to);
            }
        }

        public void addIn(int from) {
            if (!ins.contains(from)) {
                in++;
                ins.add(from);
            }
        }
    }
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) nodes[i] = new Node(i);


        for(int i=0;i<prerequisites.length;i++) {
            int task = prerequisites[i][0], pre = prerequisites[i][1];
            nodes[task].addIn(pre);
            nodes[pre].addOut(task);
        }
        for(int i=0;i<numCourses;i++) {
            if (nodes[i].in == 0) {

            }
        }

        return new int[0];
    }

    public void dfs(Node source) {
        
    }
}
