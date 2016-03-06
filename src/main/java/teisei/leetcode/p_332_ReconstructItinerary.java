package teisei.leetcode;

import java.util.*;

/**
 * Created by Teisei on 2016/3/6.
 */
public class p_332_ReconstructItinerary {

    public static void main(String[] args) {
        p_332_ReconstructItinerary test = new p_332_ReconstructItinerary();
        test.run();
    }

    public void run() {
        //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        String[][] tickets = new String[][]{
                {"JFK", "SFO"},
                {"JFK", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "JFK"},
                {"ATL", "SFO"},
        };
        //["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]
        tickets = new String[][]{
//                {"AXA", "EZE"}, {"EZE", "AUA"}, {"ADL", "JFK"}, {"ADL", "TIA"}, {"AUA", "AXA"}, {"EZE", "TIA"}, {"EZE", "TIA"}, {"AXA", "EZE"}, {"EZE", "ADL"}, {"ANU", "EZE"}, {"TIA", "EZE"}, {"JFK", "ADL"}, {"AUA", "JFK"}, {"JFK", "EZE"}, {"EZE", "ANU"}, {"ADL", "AUA"}, {"ANU", "AXA"}, {"AXA", "ADL"}, {"AUA", "JFK"}, {"EZE", "ADL"}, {"ANU", "TIA"}, {"AUA", "JFK"}, {"TIA", "JFK"}, {"EZE", "AUA"}, {"AXA", "EZE"}, {"AUA", "ANU"}, {"ADL", "AXA"}, {"EZE", "ADL"}, {"AUA", "ANU"}, {"AXA", "EZE"}, {"TIA", "AUA"}, {"AXA", "EZE"}, {"AUA", "SYD"}, {"ADL", "JFK"}, {"EZE", "AUA"}, {"ADL", "ANU"}, {"AUA", "TIA"}, {"ADL", "EZE"}, {"TIA", "JFK"}, {"AXA", "ANU"}, {"JFK", "AXA"}, {"JFK", "ADL"}, {"ADL", "EZE"}, {"AXA", "TIA"}, {"JFK", "AUA"}, {"ADL", "EZE"}, {"JFK", "ADL"}, {"ADL", "AXA"}, {"TIA", "AUA"}, {"AXA", "JFK"}, {"ADL", "AUA"}, {"TIA", "JFK"}, {"JFK", "ADL"}, {"JFK", "ADL"}, {"ANU", "AXA"}, {"TIA", "AXA"}, {"EZE", "JFK"}, {"EZE", "AXA"}, {"ADL", "TIA"}, {"JFK", "AUA"}, {"TIA", "EZE"}, {"EZE", "ADL"}, {"JFK", "ANU"}, {"TIA", "AUA"}, {"EZE", "ADL"}, {"ADL", "JFK"}, {"ANU", "AXA"}, {"AUA", "AXA"}, {"ANU", "EZE"}, {"ADL", "AXA"}, {"ANU", "AXA"}, {"TIA", "ADL"}, {"JFK", "ADL"}, {"JFK", "TIA"}, {"AUA", "ADL"}, {"AUA", "TIA"}, {"TIA", "JFK"}, {"EZE", "JFK"}, {"AUA", "ADL"}, {"ADL", "AUA"}, {"EZE", "ANU"}, {"ADL", "ANU"}, {"AUA", "AXA"}, {"AXA", "TIA"}, {"AXA", "TIA"}, {"ADL", "AXA"}, {"EZE", "AXA"}, {"AXA", "JFK"}, {"JFK", "AUA"}, {"ANU", "ADL"}, {"AXA", "TIA"}, {"ANU", "AUA"}, {"JFK", "EZE"}, {"AXA", "ADL"}, {"TIA", "EZE"}, {"JFK", "AXA"}, {"AXA", "ADL"}, {"EZE", "AUA"}, {"AXA", "ANU"}, {"ADL", "EZE"}, {"AUA", "EZE"}
                //[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
                {"JFK","KUL"}, {"JFK","NRT"}, {"NRT","JFK"}
        };

        List<String> resList = findItinerary(tickets);
        for (String e : resList) {
            System.out.print(e + "->");
        }
    }

    Map<String, List<String>> nodeMap;
    LinkedList<String> route = new LinkedList<>();
    private int numTickets = 0;
    private int numTicketsUsed = 0;

    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) return route;
        //build the graph
        numTickets = tickets.length;
        /** construct the graph*/
        nodeMap = new HashMap<>();
        int num = 0;
        for (String[] ss : tickets) {
            String from = ss[0];
            String to = ss[1];
            if (!nodeMap.containsKey(from)) nodeMap.put(from, new ArrayList<String>());
            if (!nodeMap.containsKey(to)) nodeMap.put(to, new ArrayList<String>());
            nodeMap.get(from).add(to);
        }
        for (String k : nodeMap.keySet()) {
            Collections.sort(nodeMap.get(k));
        }
        route.add("JFK");
        canFindPath("JFK");
        return route;
    }

    public void canFindPath(String from) {
        if (!nodeMap.containsKey(from)) return;
        List<String> toList = nodeMap.get(from);
        for(int i=0;i<toList.size();i++) {
            String to = toList.get(i);
            toList.remove(i);
            route.add(to);
            numTicketsUsed++;
            canFindPath(to);
            if (numTicketsUsed == numTickets) return;
            toList.add(i, to);
            route.removeLast();
            numTicketsUsed--;
        }
    }
}
