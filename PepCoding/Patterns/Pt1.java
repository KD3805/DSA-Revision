//                                 *
//                         *       *
//                 *       *       *
//         *       *       *       *
// *       *       *       *       *

package Patterns;

import java.util.Scanner;

public class Pt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int space = n - 1;
        int star = 1;

        for(int i = 1; i <= n; i++) {
            // Print spaces
            for(int j = 1; j <= space; j++) {
                System.out.print("\t");
            }

            // Print stars
            for(int k = 1; k <= star; k++) {
                System.out.print("*\t");
            }

            space--;
            star++;
            System.out.println(); // Move to the next line after each row is printed
        }
    }
}
