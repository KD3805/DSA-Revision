// Suppose there are 6 pairs of intervals. The intervals are as follows:
// [1, 3], [2, 6], [8, 10], [15, 18], [18, 21], [22, 25]
// The output of the above intervals should be:
// [1, 6], [8, 10], [15, 21], [22, 25]
// The above output is the result of merging the overlapping intervals.

// The intervals are sorted based on the starting point of the interval.
// The intervals are merged if they are overlapping.
// The intervals are merged if the starting point of the next interval is less than or equal to the ending point of the current interval.
// Ending point of the current interval is not updated if the starting point of the next interval is less than it. Instead, next interval is merged with the current interval.

import java.util.Stack;
import java.util.Arrays;

public class MergeOverlappingIntervals {

    // Here, Comparable interface is implemented to sort objects of the Pair class by overriding compareTo method and defining the sorting logic. 
    public static class Pair implements Comparable<Pair> {
        int st;
        int et;

        Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        // this > other, return +ve
        // this < other, return -ve
        // this == other, return 0
        @Override
        public int compareTo(Pair o) {
            if(this.st != o.st) {
                return this.st - o.st; // sort based on starting point of the interval
            } else {
                return this.et - o.et; // sort based on ending point of the interval
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }, { 18, 21 }, { 22, 25 } };
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        // Sort the intervals based on the starting point of the interval
        Arrays.sort(pairs);
        // Create a stack to store the merged intervals
        Stack<Pair> st = new Stack<>();

        for(int i = 0; i < pairs.length; i++) {
            if(i == 0) {
                st.push(pairs[i]);
            } else {
                Pair top = st.peek();
                // If the starting point of the next interval is less than or equal to the ending point of the current interval
                if(pairs[i].st <= top.et) {
                    // Merge the intervals by updating the ending point of the current interval
                    top.et = Math.max(top.et, pairs[i].et);
                } else {
                    // If the intervals are not overlapping, push the next interval to the stack
                    st.push(pairs[i]);
                }
            }
        }

        // Initialize the result stack to store the merged intervals in reverse order (ascending order)
        Stack<Pair> result = new Stack<>();
        while(!st.isEmpty()) {
            result.push(st.pop());
        }
        
        // Print the merged intervals
        while(!result.isEmpty()) {
            Pair p = result.pop();
            System.out.println("[" + p.st + ", " + p.et + "] ");
        }
    }    
}
