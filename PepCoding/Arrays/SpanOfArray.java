// 1. You are given n, representing the count of elements 
// 2. You are given n numbers.
// 3. You are required to find the span of input. Span is defined as difference of maximum and minimum value.


package Arrays;

import java.util.Scanner;

public class SpanOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int max = arr[0];
        int min = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(max < arr[i]) 
                max = arr[i];
            if(min > arr[i])
                min = arr[i];
        }
        int span = max - min;

        System.out.println("Maximum: "+max);
        System.out.println("Minimum: "+min);
        System.out.println("Span: "+span);
    }
}
