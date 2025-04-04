// The code starts from the end of an array and performs three major operations: 
// 1. pop(-) - It pops elements from the stack until it finds an element smaller than the current one.
// 2. ans(a) - It marks/stores the answer from the top of the stack.
// 3. push(+) - It pushes the current element into the stack.

// EXAMPLE:
// int array = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
// int nge = {5, 9, 12, 12, 12, -1, 8, -1, -1};

import java.util.Stack;

public class PepCoding_NextGreaterElementOnRight {
    public static void main(String[] args) {
        int[] a = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] nge = new int[a.length]; // nge - next greater element

        Stack<Integer> st = new Stack<>();
        st.push(a[a.length - 1]);
        nge[a.length - 1] = -1; // store -1 at the last element

        for(int i = a.length - 2; i >= 0; i--) {
            // - a +
            while (st.size() > 0 && a[i] >= st.peek() ) {
                st.pop();   
            }
            if(st.size() == 0) {
                nge[i] = -1; // greatest element of the array
            } else {
                nge[i] = st.peek(); // next greater elem on the right
            }
            st.push(a[i]);
        }
        for(int i = 0; i < nge.length; i++) {
            System.out.println(nge[i]);
        }
    }
}
