package Arrays;

import java.util.Scanner;

public class SubstractionOfArrays {
    public static void main(String[] args) {
        int[] a1 = {3, 1, 0, 7, 5};
        int[] a2 = {1, 4, 8, 5, 9, 9}; // assume that a2 is greater than a1

        int len = a1.length > a2.length ? a1.length : a2.length;
        int[] diff = new int[len];

        int c = 0;
        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = diff.length - 1;

        while(k >= 0) {
            int d = 0;
            int a1v = i >= 0 ? a1[i] : 0;

            if(a2[j] + c >= a1v) {
                c = 0;
                d = a2[j] + c - a1v;
            } else {
                c = -1;
                d = a2[j] + c + 10 - a1v; 
            } 

            diff[k] = d;

            i--;
            j--;
            k--;
        }

        int idx = 0;
        while(idx < diff.length) {
            System.out.print(diff[idx]);
            idx++;
        }
    }
}
