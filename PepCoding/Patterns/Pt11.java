// *       *       *       *                       *
//                         *                       *
//                         *                       *
// *       *       *       *       *       *       *
// *                       *
// *                       *
// *                       *       *       *       *

package Patterns;

import java.util.Scanner;

public class Pt11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j <= n; j++) {
                if((i > 1 && i <= n/2) && j <= n/2) {
                    System.out.print("\t");
                }
                else if(i > (n/2) + 1 && (j > 1 && j <= n/2)) {
                    System.out.print("\t");
                }
                else if((i > (n/2) + 1 && i < n) && j > (n/2) + 1) {
                    System.out.print("\t");
                }
                else if(i <= n/2 && (j > (n/2) + 1 && j < n)) {
                    System.out.print("\t");
                }
                else {
                    System.out.print("*\t");
                }
            }
            System.out.println();
            
        }
    }
}
