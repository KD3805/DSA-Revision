package Arrays;

import java.util.Scanner;

public class SumOfTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a1 = {3, 1, 0, 7, 5};
        int[] a2 = {1, 4, 8, 5, 9, 9};

        int len = a1.length > a2.length ? a1.length : a2.length;
        int[] sum = new int[len];

        int c = 0;
        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = sum.length - 1;

        while(k >= 0) {
            int d = c;

            if(i >= 0) {
                d += a1[i];
            }

            if(j >= 0) {
                d += a2[j];
            }

            c = d / 10; // carry
            d = d % 10; // value

            sum[k] = d;

            i--;
            j--;
            k--;
        }

        if(c != 0) {
            System.out.print(c);
        }

        for(int val : sum) {
            System.out.print(val);
        }
    }
}
