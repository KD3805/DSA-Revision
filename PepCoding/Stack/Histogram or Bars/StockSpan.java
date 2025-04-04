// Stock Span: difference of INDEX (days) between Previous Greater Element and Current Element.

// NOTE: If there are no greater element in the left (previous)
    // then Stock Span = Current Element INDEX + 1

// EXAMPLE:
// int array = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
// int span = {1, 2, 3, 1, 1, 6, 1, 2, 1};

import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] a = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] span = new int[a.length]; 

        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < a.length; i++) {
            while(!st.isEmpty() && a[i] > a[st.peek()]) {
                st.pop(); // Remove elements from the stack that are not greater than the current element
            }
            if(!st.isEmpty()) {
                span[i] = i - st.peek(); // The top of the stack now contains the previous greater element
            } else {
                span[i] = i + 1; // If the stack is empty, there is no previous greater element
            }
            st.push(i); // store INDEX of current element into stack
        }

        for(int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }
    }    
}
