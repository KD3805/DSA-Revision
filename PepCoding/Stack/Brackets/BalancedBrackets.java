import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean isBalanced = true;
            
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if(ch == ')') {
                isBalanced = handleClosing(st, '(');
            } else if(ch == '}') {
                isBalanced = handleClosing(st, '{');
            } else if(ch == ']') {
                isBalanced = handleClosing(st, '[');
            }
            if(!isBalanced) {
                System.out.println("Not Balanced");
                return;
            }
        }

        if(st.size() == 0) {
            System.out.println("Balanced");
        } else {
            // extra opening brackets
            System.out.println("Not Balanced");
        }
    }

    public static boolean handleClosing(Stack<Character> st, char corresCh) {
        // extra closing brackets
        if(st.size() == 0 || st.peek() != corresCh) {
            return false;
        } else {
            st.pop();
            return true;
        }
    }
}
