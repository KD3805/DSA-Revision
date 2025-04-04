// *                               *
// *                               *
// *               *               *
// *       *               *       *
// *                               *

package Patterns;

import java.util.Scanner;

public class Pt12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j <= n; j++) {
                if(j == 1 || j == n) {
                    System.out.print("*\t");
                }

                // for diagonals: i == j || i + j == n + 1 
                else if((i == j || i + j == n + 1) && i > n/2) {
                    System.out.print("*\t");
                }
                else {
                    System.out.print("\t");
                }
            }
            System.out.println();

        }
    }
}
