// 1
// 1       1
// 1       2       1
// 1       3       3       1
// 1       4       6       4       1
// 1       5       10      10      5       1

package Patterns;

import java.util.Scanner;

// IMPORTANT: iC(j+1) = (iCj * (i - j)) / (j + 1)

public class Pt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int iCj = 1;

            for(int j = 0; j <= i; j++) {
                System.out.print(iCj + "\t");

                int iCjP1 = (iCj * (i - j)) / (j + 1);
                iCj = iCjP1;
            }
            System.out.println();
        }
    } 
}


// Brute-force.....

// public class Pt6 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();

//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j <= i; j++) {
//                 int iCj = fact(i) / (fact(j) * fact(i - j));
//                 System.out.print(iCj + "\t");
//             }
//             System.out.println();
//         }
//     } 
    
//     private static int fact(int n) {
//         if(n == 0 || n == 1)
//             return 1;
        
//         return n * fact(n - 1);
//     }
// }
