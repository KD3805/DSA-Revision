// ((a+b)+(c+d)) -> Duplicate: false
// (a+b)+((c+d)) -> Duplicate: true

// 1. if current char is ')', then pop until corresponding '(' occur.
// 2. if current char is ')', and immediate peek of stack is '(', it mean '()' doesn't contain any content so they are duplicate.

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Stack<Character> st = new Stack<>();
        String str = sc.nextLine();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')') {
                if(st.peek() == '(') {
                    System.out.println("Duplicate: "+ true);
                    return;
                } else {
                    while(st.peek() != '(') {
                        st.pop();
                    }
                    st.pop(); // to remove '('
                }
            } else {
                st.push(ch);
            }
        }

        System.out.println("Duplacate: "+false);
    }
}
