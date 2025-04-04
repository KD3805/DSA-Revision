// EXAMPLE:
// int array = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
// int pse = {-1, 2, 5, 2, -1, 1, 1, 6, 6};

import java.util.Stack;

public class MyPreviousSmallerElement {
    public static void main(String[] args) {
        int[] a = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] pse = new int[a.length]; // pge - previous smaller element

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < a.length; i++) {
            while (st.size() > 0 && a[i] < st.peek()) {
                st.pop(); // Remove elements from the stack that are not smaller than the current element
            }
            if(st.size() > 0) {
                pse[i] = st.peek();
            } else {
                pse[i] = -1;
            }
            st.push(a[i]);
        }

        for(int i = 0; i < pse.length; i++) {
            System.out.println(pse[i]);
        }
    }    
}
