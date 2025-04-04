// EXAMPLE:
// int array = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
// int nse = {1, 3, 3, 1, -1, 6, -1, 7, -1};

import java.util.Stack;

public class MyNextSmallerElement {
    public static void main(String[] args) {
        int[] a = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] nse = new int[a.length]; // nse - next smaller element

        Stack<Integer> st = new Stack<>();

        for(int i = a.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[i] < a[st.peek()]) {
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
