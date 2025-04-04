package Arrays;

import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int element = sc.nextInt();
        int idx = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == element) {
                idx = i;
                break;
            }
        }

        System.out.println(idx);
    }
}
