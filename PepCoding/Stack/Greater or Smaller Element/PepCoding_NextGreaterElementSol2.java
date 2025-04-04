// The code starts from the start of an array, stores first element INDEX (only) into stack, then performs three major operations: 
// 1. pop(-) - It pops elements from the stack until current element(a[i]) is greater than peek of stack(a[st.peek()])
// 2. ans(a) - It marks/stores the current element to [nge] at [st.peek()] INDEX.
// 3. push(+) - It pushes the current element INDEX into the stack.

// EXAMPLE:
// int array = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
// int nge = {5, 9, 12, 12, 12, -1, 8, -1, -1};

import java.util.Stack;

public class PepCoding_NextGreaterElementSol2 {
    public static void main(String[] args) {
        int[] a = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] nge = new int[a.length]; // nge - next greater element

        Stack<Integer> st = new Stack<>();
        st.push(0); // store possition of elements into stack

        for(int i = 1; i < a.length; i++) {
            while(st.size() > 0 && a[i] > a[st.peek()]) {
                int pos = st.peek(); // get INDEX of smaller element from peek of stack
                nge[pos] = a[i]; // store next greater element (a[i]) to [nge] at smaller element POSITION.
                st.pop(); // get RID of smaller element from stack
            }
            st.push(i); // store current element INDEX into the stack. 
        }

        // elements of array who don't have NGE on right remain in stack.
        while(st.size() > 0) {
            int pos = st.peek(); 
            nge[pos] = -1; 
            st.pop();
        }

        for(int i = 0; i < nge.length; i++) {
            System.out.println(nge[i]);
        }
    }
}
