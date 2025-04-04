// Enter a number: 
// 5
// Enter 5 numebrs...
// 3
// 5
// 4
// 7
// 2
// Maximum: 7
//                         *
//                         *
//         *               *
//         *       *       *
// *       *       *       *
// *       *       *       *       *
// *       *       *       *       *

package Arrays;

import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter "+n+" numebrs...");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(max < arr[i]) 
                max = arr[i];
        }

        System.out.println("Maximum: "+max);

        for(int floor = max; floor >= 1; floor--) {
            for(int i = 0; i < n; i++) {
                if(arr[i] >= floor) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
