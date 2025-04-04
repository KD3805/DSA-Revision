// **Reference**
// Youtube (PepCoding): https://youtu.be/0do2734xhnU?si=8juI9nxEYx_fgzNd

// **Introduction to the Problem**
// The problem involves finding the largest rectangle that can be formed within a histogram. This problem is significant in various applications including computational geometry and data visualization.

// **Understanding the Histogram**
// The histogram is represented as a series of bars, each with a specific height. The goal is to identify the largest rectangular area that can be formed using these bars. Each bar's height represents the height of the rectangle, while the width is influenced by the bars to the left and right of it. The area of a rectangle is calculated as height multiplied by width.

// **Algorithm Approach**
// To solve this problem effectively, a two-pass stack-based approach is employed. 
// 1. **First Pass (Next Smaller Element)**: Iterate through the histogram from right to left, maintaining a stack of indices. For each bar, pop the stack until a smaller bar is found, and mark the popped bar's next smaller element as the current bar's index. If no smaller bar is found, mark the next smaller element as the histogram's end.
// 2. **Second Pass (Previous Smaller Element)**: Iterate through the histogram from left to right, maintaining a stack of indices. For each bar, pop the stack until a smaller bar is found, and mark the popped bar's previous smaller element as the current bar's index. If no smaller bar is found, mark the previous smaller element as the histogram's start.
// 3. **Calculating Area**: Calculate the area of each rectangle using the width (difference between next and previous smaller elements) and height (bar's height).

// **Complexity Analysis**
// The time complexity of this algorithm is O(n), where n is the number of bars in the histogram. This efficiency arises from the fact that each bar is pushed and popped from the stack only once. The space complexity is O(n) as well, due to the stack storage.

import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        int[] hist = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        // int[] hist = { 6, 2, 5, 4, 5, 1, 6 };
        
        int[] rb = myNextSmallerElement(hist); // rb - right boundry of area
        int[] lb = myPreviousSmallerElement(hist); // lb - left boundry of area

        int maxArea = 0;
        for(int i = 0; i < hist.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int length = hist[i];
            int area = width * length;

            if(area > maxArea) {
                maxArea = area;
            }
        }

        System.out.println("Largest Area Histogram: "+maxArea);
    }

    private static int[] myNextSmallerElement(int[] a) {
        int[] nse = new int[a.length]; // nse - next smaller element
        int rb = a.length; // RIGHT BOUNDRY = ARRAY LENGTH

        Stack<Integer> st = new Stack<>();
        st.push(a.length - 1); // push last element INDEX
        nse[a.length - 1] = rb; // SET RIGHT BOUNDRY

        for(int i = a.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && a[i] <= a[st.peek()]) {
                st.pop(); // Remove elements from the stack that are not smaller than the current element
            }
            if(!st.isEmpty()) {
                nse[i] = st.peek(); // Store index of next smaller element
            } else {
                nse[i] = rb;
            }
            st.push(i);
        }

        return nse;
    }


    public static int[] myPreviousSmallerElement(int[] a) {
        int[] pse = new int[a.length];
        int lb = -1; // LEFT BOUNDRY = -1

        Stack<Integer> st = new Stack<>();
        st.push(0); // push first element INDEX
        pse[0] = lb; // SET LEFT BOUNDRY

        for(int i = 1; i < a.length; i++) {
            while (!st.isEmpty() && a[i] <= a[st.peek()]) {
                st.pop(); // get rid of greater elements from stack
            }

            if(!st.isEmpty()) {
                pse[i] = st.peek(); // Store index of previous smaller element
            } else {
                pse[i] = lb;
            }

            st.push(i);
        }

        return pse;
    }
}
