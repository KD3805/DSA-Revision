// EXAMPLE:
// int array = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
// int nse = {1, 3, 3, 1, -1, 6, -1, 7, -1};

import java.util.Stack;

public class MyNextSmallerElement {
    public static void main(String[] args) {
        int[] a = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] nse = new int[a.length]; // nse - next smaller element

        Stack<Integer> st = new Stack<>();
        st.push(a[a.length - 1]); // Push the last element of the array into the stack
        nse[a.length - 1] = -1; // The last element has no next smaller element

        for(int i = a.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[i] < a[st.peek()]) {
                // get RID of larger element from stack
                st.pop(); // Remove elements from the stack that are not smaller than the current element
            }
            if(!st.isEmpty()) {
                nse[i] = a[st.peek()];
            } else {
                nse[i] = -1;
            }
            st.push(i);
        }

        for(int i = 0; i < nse.length; i++) {
            System.out.println(nse[i]);
        }
    }    
}
