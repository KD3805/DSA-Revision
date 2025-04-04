package Strings;
import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any word/sentence : ");
        String str = sc.nextLine();
        
        StringBuilder sb = new StringBuilder(str);
        reverseString(sb);

        
    }

    public static void reverseString(StringBuilder sb) {
        for(int i=0; i<sb.length()/2; i++) {                                                                                                                                                                                                                                                                                                                
            int front = i;
            int back = sb.length()-i-1; 

            char frontChar = sb.charAt(front);
            char backChar = sb.charAt(back);

            sb.setCharAt(front, backChar);
            sb.setCharAt(back, frontChar);
        }
        System.out.println("Reverse word/sentence : "+sb);
    }
    
}
