// Celibrity:
// - known by everybody
// - knows nobody

package Stack.Celibrity;

import java.util.Stack;

public class CelibrityProblem {
    public static void main(String[] args) {
        int[][] arr = { { 0, 0, 1, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };
        //                   [0]            [1]             [2]             [3]              
        // here, [2] is known by everybody but [2] knows nobody

        // 1. push all the elements in the stack
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        // 2. pop 2 elements and check if i knows j
        while(st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();

            if(arr[i][j] == 1) {
                // if i knows j ==> i is not a celibrity
                st.push(j);
            } else {
                // if i doesn't know j ==> j is not a celibrity
                st.push(i);
            }
        }

        // 3. potential celibrity
        int potential = st.pop();
        // 4. check if potential celibrity is known by everybody and knows nobody
        for(int i = 0; i < arr.length; i++) {
            if(i != potential) {
                // if potential celibrity knows i or i doesn't know potential celibrity ==> potential celibrity is not a celibrity
                if(arr[i][potential] == 0 || arr[potential][i] == 1) {
                    System.out.println("No Celibrity");
                    return;
                }
            }
        }
        System.out.println("Celibrity: " + potential);
    }
}
