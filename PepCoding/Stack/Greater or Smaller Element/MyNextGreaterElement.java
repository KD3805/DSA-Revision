// The code starts from the end of an array and performs three major operations: 
// 1. pop(-) - It pops elements from the stack until current element(a[i]) is greater than peek of stack(st.peek())
// 2. ans(a) - It marks/stores the current element to [nge].
// 3. push(+) - It pushes the current element into the stack.

// EXAMPLE:
// int array = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
// int nge = {5, 9, 12, 12, 12, -1, 8, -1, -1};

import java.util.Stack;

public class MyNextGreaterElement {
    public static void main(String[] args) {
        int[] a = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] nge = new int[a.length]; // nge - next smaller element

        Stack<Integer> st = new Stack<>();
        st.push(a[a.length - 1]); // Push the last element of the array into the stack
        nge[a.length - 1] = -1; // The last element has no next greater element

        for(int i = a.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[i] > st.peek()) {
                // get RID of smaller element from stack
                st.pop(); // Remove elements from the stack that are not greater than the current element
            }
            if(!st.isEmpty()) {
                nge[i] = st.peek(); // The top of the stack now contains the next greater element
            } else {
                nge[i] = -1; // If the stack is empty, there is no next greater element
            }
            st.push(a[i]); // Push the current element into the stack
        }

        
        for(int i = 0; i < nge.length; i++) {
            System.out.println(nge[i]);
        }
    }
}
