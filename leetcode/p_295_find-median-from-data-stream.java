/**
	Problem:
	Median is the middle value in an ordered integer list.
	If the size of the list is even, there is no middle value, so the median is the mean of the two middle value.
	Example:
	1) [2, 3, 4] => 3
	2) [2, 3] => (2 + 3) / 2 = 2.5
	Design a data structure that supports the following two operations:
	1) void addNum(int num) - add an integer number from the data stream to the data structure;
	2) double findMedian() - return the median of all elements so far.

	Constraints:
	1) data stream: unlimited number of integers;
	2) operations: add, findMedian;
	3) contain duplicates? yes or no
	4) range of the elements: INT_MIN <= X <= INT_MAX

	Ideas:
	1) use a sorted list
	addNum: add the element to the position so that the list maintains order;
	getMedian: find the median one or the two;
	time: O(log n), O(log n)
	space: O(n)

	2) use two priority queue
		(1) Q1: Min Queue, Q2: Max Queue;
		(2) Q1.top >= Q2.top;
		(3) Q1.size - Q2.size == 0 or 1.
	getMedian:
		(1) if even, (Q1.top + Q2.top)/2,
		(2) if odd, Q1.top
	addNum:
		(1) if Q1.size == Q2.size, Q1.add(x)
		(2) else compare x with y = Q1.top,
			(1) x <= y, Q2.add(x)
			(2) y = Q1.pop(); Q1.add(x); Q2.add(y)
	Issue: priority queue can not contains duplicates;


*/
public class MedianFinder {

	PriorityQueue<Integer> Q1 = new PriorityQueue<>();
	PriorityQueue<Integer> Q2 = new PriorityQueue<>(Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (Q1.size() == 0) {
            Q1.add(num);
        } else if (Q1.size() == Q2.size()) {
            int max = num;
            if (max < Q2.peek()) {
                Q2.add(max);
                max = Q2.poll();
            }
            Q1.add(max);
        } else {
            int min = num;
            if (num > Q1.peek()) {
                Q1.add(num);
                min = Q1.poll();
            }
            Q2.add(min);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
		if (Q1.size() != Q2.size()) {
			return (double) Q1.peek();
		} else {
			return (double) (Q1.peek() + Q2.peek()) / (double) 2;
		}
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
