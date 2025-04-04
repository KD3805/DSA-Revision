// Suppose there are 6 pairs of intervals. The intervals are as follows:
// [1, 3], [2, 6], [8, 10], [15, 18], [18, 21], [22, 25]
// The output of the above intervals should be:
// [1, 6], [8, 10], [15, 21], [22, 25]
// The above output is the result of merging the overlapping intervals.

// The intervals are sorted based on the starting point of the interval.
// The intervals are merged if they are overlapping.
// The intervals are merged if the starting point of the next interval is less than or equal to the ending point of the current interval.


public class MergeOverlappingIntervals {

    public static class Pair implements Comparable<Pair> {
        int st;
        int et;

        Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        public int compareTo(Pair o) {
            return this.st - o.st;
        }
    
        
    }

    public static void main(String[] args) {
        
    }    
}
