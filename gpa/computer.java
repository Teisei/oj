package teisei.algo.gpa;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Teisei on 2016/3/8.
 */
public class computer {
    public static void main(String[] args) {
        Map<String, Double[]> scores = new HashMap<>();
        scores.put("C语言",       new Double[]{75.0, 4.0});
        scores.put("思想道德",   new Double[]{85.0, 2.5});
        scores.put("体育1", new Double[]{85.0, 1.0});
        scores.put("离散数学", new Double[]{86.0, 4.0});
        scores.put("职业生涯规划", new Double[]{85.0, 0.5});
        scores.put("日语精读1", new Double[]{95.0, 6.0});
        scores.put("计算机基础", new Double[]{77.0, 3.0});
        scores.put("高等数学1", new Double[]{86.0, 5.0});
        scores.put("军事训练", new Double[]{85.0, 3.0});
        scores.put("中国近现代史刚要", new Double[]{95.0, 1.5});
        scores.put("Java语言程序设计", new Double[]{95.0, 3.0});
        scores.put("日语精读2", new Double[]{92.0, 8.0});
        scores.put("计算机组织与结构", new Double[]{85.0, 4.0});
        scores.put("军事理论", new Double[]{95.0, 2.0});
        scores.put("高等数学2", new Double[]{83.0, 5.0});
        scores.put("线性代数", new Double[]{87.0, 2.5});
        scores.put("大学生心理健康教育", new Double[]{85.0, 1.0});
        scores.put("体育2", new Double[]{95.0, 1.0});
        scores.put("日语试听1", new Double[]{87.0, 2.0});
        scores.put("数据结构", new Double[]{91.0, 4.0});
        scores.put("马刺四主义基本原理", new Double[]{86.0, 3.0});
        scores.put("日语视听2", new Double[]{98.0, 2.0});
        scores.put("概率论与数理统计", new Double[]{100.0, 3.0});
        scores.put("软件工程导论", new Double[]{75.0, 2.0});
        scores.put("体育3", new Double[]{75.0, 1.0});
        scores.put("软对激励与沟通", new Double[]{88.0, 1.0});
        scores.put("工程经济学", new Double[]{88.0, 2.0});
        scores.put("互联网软件基础", new Double[]{92.0, 2.0});
        scores.put("毛概", new Double[]{86.0, 4.0});
        scores.put("日语视听3", new Double[]{90.0, 4.0});
        scores.put("编译原理", new Double[]{78.0, 3.0});
        scores.put("日语精读4", new Double[]{96.0, 6.0});
        scores.put("体育4", new Double[]{95.0, 1.0});
        scores.put("Matlab工程仿真设计基础", new Double[]{95.0, 2.0});
        scores.put("数据库原理", new Double[]{94.0, 4.0});
        scores.put("面向对象VC++", new Double[]{85.0, 2.0});
        scores.put("。Net体系编程", new Double[]{83.0, 3.0});
        scores.put("软件设计与体系结构", new Double[]{91.0, 3.0});
        scores.put("英语（二外）", new Double[]{82.0, 4.0});
        scores.put("就业指导", new Double[]{85.0, 0.5});
        scores.put("计算方法", new Double[]{87.0, 2.0});
        scores.put("信息系统分析与设计", new Double[]{86.0, 3.0});
        scores.put("SQL SERVER数据库应用技术", new Double[]{90.0, 2.0});
        scores.put("操作系统", new Double[]{90.0, 4.0});
        scores.put("信息系统分析与设计课程设计", new Double[]{95.0, 2.0});
        scores.put("专业英语", new Double[]{95.0, 2.0});
        scores.put("计算机网络", new Double[]{95.0, 3.5});
        scores.put("英语（二外）", new Double[]{89.0, 4.0});
        printMap(scores);
    }

    public static void printMap(Map<String, Double[]> map) {
        double sum = 0.0;
        double num = 0.0;
        for (String k : map.keySet()) {
            sum += trans(map.get(k)[0]) * map.get(k)[1];
            num += map.get(k)[1];
        }
        System.out.println(sum + "\t" + num + "\t" + (Double) sum / num);
    }

    public static double trans(double x) {
        if(x>=90) return 4.0;
        else if(x>=85) return 3.5;
        else if(x>=80) return 3.0;
        else if(x>=75) return 2.5;
        else if(x>=70) return 2.0;
        else if(x>=65) return 1.5;
        else if(x>=60) return 1.0;
        else return 0;
    }
}
