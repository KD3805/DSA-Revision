// EXAMPLE:
// int array = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
// int pge = {-1, -1, -1, 9, 3, -1, 12, 12, 8};

import java.util.Stack;

public class MyPreviousGreaterElement {
    public static void main(String[] args) {
        int[] a = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] pge = new int[a.length]; // pge - previous greater element

        Stack<Integer> st = new Stack<>();
        st.push(a[0]); // Push the first element of the array into the stack
        pge[0] = -1; // The first element has no previous greater element

        for(int i = 0; i < a.length; i++) {
            while (st.size() > 0 && a[i] > st.peek()) {
                st.pop(); // Remove elements from the stack that are not greater than the current element
            }
            if(st.size() > 0) {
                pge[i] = st.peek(); // The top of the stack now contains the previous greater element
            } else {
                pge[i] = -1; // If the stack is empty, there is no previous greater element
            }
            st.push(a[i]); // Push the current element into the stack
        }

        for(int i = 0; i < pge.length; i++) {
            System.out.println(pge[i]);
        }
    }
}