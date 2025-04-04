import java.util.Stack;

/**
 * SlidingWindowMaximum Class
 * 
 * Goal:
 * This class aims to find the maximum value in each sliding window of size 'k'
 * within a given array of integers. The output will be the maximum value for each
 * window as it slides from the start to the end of the array.
 * 
 * Algorithm Approach:
 * 1. **Edge Case Handling**: First, we check if the window size 'k' is greater than
 *    or equal to the length of the array. If it is, we simply find and print the
 *    maximum value of the entire array, as there is only one window in this case.
 * 
 * 2. **Next Greater Element**: We utilize a stack-based approach to find the next
 *    greater element for each element in the array. This helps in efficiently
 *    determining the maximum value within the current sliding window.
 * 
 * 3. **Sliding Window Maximum Calculation**: We iterate through the array using a
 *    two-pointer technique. For each starting index of the window, we determine
 *    the maximum value by checking the next greater elements within the bounds of
 *    the current window size 'k'.
 * 
 * Why This Approach:
 * This method is efficient because it reduces the time complexity of finding the
 * maximum in each window from O(k) to O(1) by leveraging the next greater element
 * technique. The overall time complexity of the algorithm is O(n), where n is the
 * length of the array, making it suitable for larger datasets.
 */

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        // int[] a = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] a = { 2, 5, 9, 3 };
        int k = 4; // WINDOW SIZE

        // Handle edge case where k is greater than or equal to the length of the array
        if (k >= a.length) {
            int max = Integer.MIN_VALUE;
            for (int num : a) {
                if (num > max) {
                    max = num;
                }
            }
            System.out.println(max);
            return;
        }

        int[] nge = myNextGreaterElement(a); // array of next greater element

        int j = 0; // two-pointer variable
        // find maximum of window
        for(int i = 0; i < a.length - k; i++) {
            // update j if it gets behind
            if(j < i) {
                j = i;
            }
            // find next greater element within WINDOW SIZE 'k'
            while (j < nge.length && nge[j] < i + k) {
                j = nge[j];
            }

            System.out.println(a[j]);
        }
    }

    private static int[] myNextGreaterElement(int[] a) {
        int[] nge = new int[a.length];
        int rb = a.length;

        Stack<Integer> st = new Stack<>();
        st.push(a.length - 1);
        nge[a.length - 1] = rb;

        for(int i = a.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && a[i] >= a[st.peek()]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                nge[i] = st.peek();
            } else {
                nge[i] = rb;
            }
            st.push(i);
        }

        return nge;
    }
}
