package teisei.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Teisei on 2016/6/3.
 */
public class p_56_MergeIntervals {
    public static void main(String[] args) {
        new p_56_MergeIntervals().run();

    }

    public void run() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(2, 3));
        list.add(new Interval(0, 1));
        list.add(new Interval(1, 2));
        list.add(new Interval(4, 5));
        list.add(new Interval(3, 4));

        merge(list);
    }


    public List<Interval> merge(List<Interval> intervals) {
        printList(intervals);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start - o2.start < 0) return -1;
                else if(o1.start == o2.start){
                    if (o1.end < o2.end) return -1;
                    else if(o1.end == o2.end) return 0;
                    else return 1;
                } else return 1;
            }
        });

        System.out.println("******************");
        printList(intervals);
        return intervals;
    }

    private void printList(List<Interval> list) {
        for (Interval i : list) {
            System.out.println(i.start + "\t" + i.end);
        }
    }
}

class Interval {
    int start, end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}